import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandInsert extends Command {
    /**
     * Команда, добавляющая новый элемент в коллекцию
     */
    private Map<Integer, SpaceMarine> lhm;
    public CommandInsert(Map<Integer, SpaceMarine> lhm) {
        this.name = "insert";
        this.description = "Add a new item with the given key";
        this.lhm = lhm;
    }

    @Override
    public void execute(Scanner sc) {
        System.out.print("\tInput a key: ");
        int key = sc.nextInt();
        SpaceMarine sm = new SpaceMarine();
        sm.scan(sc);
        lhm.put(key, sm);
        System.out.printf("Element with key %d has been inserted\n", key);
    }
}
