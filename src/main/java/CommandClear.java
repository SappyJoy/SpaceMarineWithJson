import java.util.Map;
import java.util.Scanner;

/**
 * Command which clear all collection
 */
public class CommandClear extends Command {
    private Map<Integer, SpaceMarine> lhm;
    public CommandClear(Map<Integer, SpaceMarine> lhm) {
        this.name = "clear";
        this.description = "Clear collection";
        this.lhm = lhm;
    }

    @Override
    public void execute(Scanner sc) {
        lhm.clear();
    }
}
