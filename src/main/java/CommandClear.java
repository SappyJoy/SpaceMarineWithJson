import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandClear extends Command {
    /**
     * Команда, стирающая всю коллекцию
     */
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
