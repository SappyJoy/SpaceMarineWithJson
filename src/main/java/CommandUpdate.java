import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class CommandUpdate extends Command {
    /**
     * Command which changes an element by given id
     */
    private Map<Integer, SpaceMarine> lhm;

    public CommandUpdate(Map<Integer, SpaceMarine> lhm) {
        this.name = "update";
        this.description = "Updates the value of a collection element whose id is equal to the specified";
        this.lhm = lhm;
    }

    @Override
    public void execute(Scanner sc) {
        int id;
        while (true) {
            try {
                id = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input");
                sc.next();
            }
        }
        SpaceMarine sm = new SpaceMarine();
        sm.scan(sc);
        sm.setId(id);
        // Необходимо найти элемент в коллекции по id
        // Здесь будет реализовано полным перебором, впоследствии возможны изменения
        for (Integer key : lhm.keySet()) {
            SpaceMarine value = lhm.get(key);
            if (value.getId() == id) {
                lhm.put(key, sm);
                return;
            }
        }
        System.out.println("Not found any elements with the given id");
    }
}
