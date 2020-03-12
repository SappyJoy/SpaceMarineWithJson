import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Command that removes from the collection all items that exceed the specified
 */
public class CommandRemoveGreater extends Command {

    Map<Integer, SpaceMarine> lhm;

    public CommandRemoveGreater(Map<Integer, SpaceMarine> lhm) {
        this.name = "remove_greater";
        this.description = "Removes from the collection all items that exceed the specified";
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
            if (value.compareTo(spaceMarine) <= 0) {
                copyLhm.put(key, value);
            }
        }
        lhm.clear();
        lhm.putAll(copyLhm);
    }
}
