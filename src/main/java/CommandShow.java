import java.util.Map;
import java.util.Scanner;

public class CommandShow extends Command {
    /**
     * Выводит в консоль всю коллекцию
     */
    private Map<Integer, SpaceMarine> lhm;
    public CommandShow(Map<Integer, SpaceMarine> lhm) {
        this.name = "show";
        this.description = "Outputs to the standard output stream all the elements of the collection in a string representation";
        this.lhm = lhm;
    }

    @Override
    public void execute(Scanner sc) {
        for (int i : lhm.keySet()) {
            System.out.println("key=" + i + ", value=" + lhm.get(i));
        }
    }
}
