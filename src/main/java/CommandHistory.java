import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Show last 9 used commands
 */
public class CommandHistory extends Command {

    List<String> history;

    public CommandHistory(List<String> history) {
        this.name = "history";
        this.description = "Displays the last 9 commands (without their arguments)";
        this.history = history;
    }

    @Override
    public void execute(Scanner sc) {
        List<String> tail = history.subList(Math.max(history.size() - 9, 0), history.size());
        for (String cmd : tail)
            System.out.println(cmd);
    }
}
