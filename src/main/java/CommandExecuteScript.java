import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
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
            String name = in.next();
            Command cmd = commandManager.getCommand(name);
            cmd.execute(in);
            history.add(name);
        }
    }

    private static String makePath(String fileName) {
        return "./src/main/resources/" + fileName + ".txt";
    }
}
