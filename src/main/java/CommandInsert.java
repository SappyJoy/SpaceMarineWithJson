import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * Command adding a new item to the collection
 */
public class CommandInsert extends Command {
    private Map<Integer, SpaceMarine> lhm;
    public CommandInsert(Map<Integer, SpaceMarine> lhm) {
        this.name = "insert";
        this.description = "Add a new item with the given key";
        this.lhm = lhm;
    }

    @Override
    public void execute(Scanner sc) {
        System.out.print("\tInput a key: ");
        int key;
        while (true) {
            try {
                key = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input should be integer");
                sc.next();
            }
        }
        SpaceMarine sm = new SpaceMarine();
        sm.scan(sc);
        lhm.put(key, sm);
        System.out.printf("Element with key %d has been inserted\n", key);
    }
}
