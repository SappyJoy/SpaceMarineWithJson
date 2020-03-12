package SpaceMarine;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * SpaceMarine.Command which removes from the collection all elements smaller than the specified
 */
public class CommandRemoveLower extends Command {

    Map<Integer, SpaceMarine> lhm;

    public CommandRemoveLower(Map<Integer, SpaceMarine> lhm) {
        this.name = "remove_lower";
        this.description = "Removes from the collection all elements smaller than the specified";
        this.lhm = lhm;
    }

    @Override
    public void execute(Scanner sc) {
        SpaceMarine spaceMarine = new SpaceMarine();
        spaceMarine.scan(sc);
        Map<Integer, SpaceMarine> copyLhm = new LinkedHashMap<>();
        for (Map.Entry<Integer, SpaceMarine> entry : lhm.entrySet()) {
            int key = entry.getKey();
            SpaceMarine value = entry.getValue();
            if (value.compareTo(spaceMarine) >= 0) {
                copyLhm.put(key, value);
            }
        }
        lhm.clear();
        lhm.putAll(copyLhm);
    }
}
