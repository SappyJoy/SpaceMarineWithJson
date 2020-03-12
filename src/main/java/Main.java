import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String fileName = "data";
        if (args.length > 0)
            fileName = args[0];

        File file;
        while (true) {
            String relativePath = makePath(fileName);
            file = new File(relativePath);
            try {
                file = new File(relativePath);
                file.createNewFile();
                break;
            } catch (IOException e) {
                System.err.println("Wrong input");
                fileName = getFileName();
            }
        }


        List<String> history = new LinkedList<>();
        LinkedHashMap<Integer, SpaceMarine> lhm = new LinkedHashMap<>();
        // добавить элементы из файла в lhm
        WorkWithJson workWIthJson = new WorkWithJson(file);
        lhm = workWIthJson.getLhm();


        CommandManager commandManager = new CommandManager();
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

    private static String makePath(String fileName) {
        return "./src/main/resources/" + fileName + ".json";
    }

    private static String getFileName() {
        Scanner in = new Scanner(System.in);
        return in.next();
    }
}