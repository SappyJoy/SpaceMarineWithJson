import java.util.Scanner;

/**
 * Abstract class for executable commands
 */
abstract class Command implements Executable {
    String name;
    String description;
    public abstract void execute(Scanner sc);
    String getName() {
        return name;
    }
    String getDescription() {
        return description;
    }
}
