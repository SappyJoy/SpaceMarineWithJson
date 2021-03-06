package SpaceMarine;

import java.io.*;
import java.util.*;

/**
 * SpaceMarine.Command to execute commands from a file
 */
public class CommandExecuteScript extends Command {

    Map<Integer, SpaceMarine> lhm;
    File file;
    CommandManager commandManager;

    public CommandExecuteScript(Map<Integer, SpaceMarine> lhm, File file, CommandManager commandManager) {
        this.name = "execute_script [name of script file]";
        this.description = "Reads and executes the script from the specified file" +
                " The script contains commands in " +
                "the same form in which they are entered by the user interactively.";
        this.lhm = lhm;
        this.file = file;
        this.commandManager = commandManager;
    }

    @Override
    public void execute(Scanner sc) {
        List<String> history = new LinkedList<>();
        String fileName = sc.next();
        fileName = makePath(fileName);
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }
        Scanner in = new Scanner(new InputStreamReader(fileInputStream));
        // Создать новый файл, если имя файла указано некорректно запросить повторить ввод
        while (in.hasNextLine()) {
            // !!!!! Если присутствует комманда execute_script, проверить не ссылается ли она на тот же файл
            String name = "";
            while (in.hasNextLine()) {
                try {
                    name = in.next();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Wrong input");
                } catch (NoSuchElementException e) {
                    continue;
                }
            }
            Command cmd = commandManager.getCommand(name);
            if (name.equals("execute_script")) {
                System.out.println("You can't use \'execute_script\' in script file");
                in.nextLine();
            } else if (cmd == null) {
                // System.out.println("Command not found");
            } else {
                cmd.execute(in);
                history.add(name);
            }
        }
    }

    private static String makePath(String fileName) {
        return  fileName + "";
    }
}
