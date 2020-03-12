import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class CommandExecuteScript extends Command {
    /**
     * Класс для исполнения команд из файла
     */

    Map<Integer, SpaceMarine> lhm;
    File file;
    CommandManager commandManager;

    public CommandExecuteScript(Map<Integer, SpaceMarine> lhm, File file, CommandManager commandManager) {
        this.name = "execute_script [name of script file]";
        this.description = "Reads and executes the script from the specified file (Placed in \"resources\" Folder." +
                " The script contains commands in " +
                "the same form in which they are entered by the user interactively.";
        this.lhm = lhm;
        this.file = file;
        this.commandManager = commandManager;
    }

    @Override
    public void execute(Scanner sc) throws IOException {
        List<String> history = new LinkedList<>();
        String fileName = sc.next();
        fileName = makePath(fileName);
        FileInputStream fileInputStream = new FileInputStream(fileName);
        Scanner in = new Scanner(new InputStreamReader(fileInputStream));
        // Создать новый файл, если имя файла указано некорректно запросить повторить ввод
        while (in.hasNextLine()) {
            // !!!!! Если присутствует комманда execute_script, проверить не ссылается ли она на тот же файл
            String name;
            while (true) {
                try {
                    name = in.next();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Wrong input");
                }
            }
            Command cmd = commandManager.getCommand(name);
            if (name.equals("execute_script")) {
                System.out.println("You can't use \'execute_script\' in script file");
            } else if (cmd == null) {
                System.out.println("Command not found");
            } else {
                cmd.execute(in);
                history.add(name);
            }
        }
    }

    private static String makePath(String fileName) {
        return "./src/main/resources/" + fileName + ".txt";
    }
}
