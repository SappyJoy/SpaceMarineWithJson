import java.util.Scanner;

public class CommandExit extends Command {
    /**
     *  Завершает программу
     */

    public CommandExit() {
        this.name = "exit";
        this.description = "Terminate the program (without saving to a file)";
    }

    public void execute(Scanner sc) {
        System.exit(0);
    }
}
