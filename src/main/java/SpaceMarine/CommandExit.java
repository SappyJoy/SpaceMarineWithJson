package SpaceMarine;

import java.util.Scanner;

/**
 * Complete the entire program
 */
public class CommandExit extends Command {

    public CommandExit() {
        this.name = "exit";
        this.description = "Terminate the program (without saving to a file)";
    }

    public void execute(Scanner sc) {
        System.exit(0);
    }
}
