package SpaceMarine;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * SpaceMarine.Command which removes an item from the collection by its key
 */
public class CommandRemoveKey extends Command {
    /**
     * Removes an item from the collection by its key
     */
    private Map<Integer, SpaceMarine> lhm;
    public CommandRemoveKey(Map<Integer, SpaceMarine> lhm) {
        this.name = "remove_key key";
        this.description = "Removes an item from the collection by its key";
        this.lhm = lhm;
    }

    @Override
    public void execute(Scanner sc) {
        int removeKey;
        while (true) {
            try {
                removeKey = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input");
                sc.next();
            }
        }
        for (Integer key : lhm.keySet()) {
            if (key.equals(removeKey)) {
                lhm.remove(removeKey);
                System.out.println("Element has been removed");
                return;
            }
        }
        System.out.printf("Key %d not found\n", removeKey);
    }
}
