package SpaceMarine;

import java.util.HashMap;

/**
 * SpaceMarine.CommandManager executes a command corresponding to the input
 */
public class CommandManager {

    HashMap<String, Command> hm = new HashMap<>();

    void addCommand(String name, Command cmd) {
        hm.put(name, cmd);
    }

    Command getCommand(String name) {
        return hm.get(name);
    }

    public HashMap<String, Command> getHm() {
        return hm;
    }
}
