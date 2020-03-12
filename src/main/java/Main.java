import java.io.*;
import java.util.*;

/**
 *  Class that runs the program. It's responsible for reading commands
 * @author Stepan Ponomaryov
 * @version 1.0 2020-03-12
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File file = createFile(sc, args);

        LinkedHashMap<Integer, SpaceMarine> lhm;
        // добавить элементы из файла в lhm
        WorkWithJson workWIthJson = new WorkWithJson(file);
        lhm = workWIthJson.getLhm();

        List<String> history = new LinkedList<>();
        CommandManager commandManager = new CommandManager();
        addCommands(commandManager, lhm, file, history);

        // Главный цикл, получающий на вход комманду и выполняющий её
        run(sc, commandManager, history);
    }
    private static void run(Scanner sc, CommandManager commandManager, List<String> history) {
        while(true) {
            String name;
            while (true) {
                try {
                    name = sc.next();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Wrong input");
                }
            }
            Command cmd = commandManager.getCommand(name);
            if (cmd == null) {
                System.out.println("Command not found");
            } else {
                cmd.execute(sc);
                history.add(name);
            }
        }
    }
    private static void addCommands(CommandManager commandManager, LinkedHashMap<Integer, SpaceMarine> lhm, File file,
                                    List<String> history) {
        commandManager.addCommand("insert", new CommandInsert(lhm));
        commandManager.addCommand("show", new CommandShow(lhm));
        commandManager.addCommand("update", new CommandUpdate(lhm));
        commandManager.addCommand("remove_key", new CommandRemoveKey(lhm));
        commandManager.addCommand("clear", new CommandClear(lhm));
        commandManager.addCommand("save", new CommandSave(lhm, file));
        commandManager.addCommand("exit", new CommandExit());
        commandManager.addCommand("remove_greater", new CommandRemoveGreater(lhm));
        commandManager.addCommand("remove_lower", new CommandRemoveLower(lhm));
        commandManager.addCommand("history", new CommandHistory(history));
        commandManager.addCommand("count_by_weapon_type", new CommandCountByWeaponType(lhm));
        commandManager.addCommand("filter_less_than_health", new CommandFilterLessThanHealth(lhm));
        commandManager.addCommand("print_field_ascending_chapter", new CommandPrintFieldAscendingChapter(lhm));
        commandManager.addCommand("info", new CommandInfo(lhm));
        commandManager.addCommand("help", new CommandHelp(commandManager));
        commandManager.addCommand("execute_script", new CommandExecuteScript(lhm, file, commandManager));
    }
    private static File createFile(Scanner scanner, String[] args) {
        String fileName = "data";
        if (args.length > 0)
            fileName = args[0];
        File file;
        while (true) {
            String relativePath = makePath(fileName);
            try {
                file = new File(relativePath);
                file.createNewFile();
                break;
            } catch (IOException e) {
                System.err.println("Wrong input");
                fileName = getFileName();
            }
        }
        return file;
    }
    private static String makePath(String fileName) {
        return "./src/main/resources/" + fileName + ".json";
    }
    private static String getFileName() {
        Scanner in = new Scanner(System.in);
        return in.next();
    }
}