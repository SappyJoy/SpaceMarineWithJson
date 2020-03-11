import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

abstract class Command {
    String name;
    String description;
    abstract void execute(Scanner sc) throws FileNotFoundException, IOException;
    String getName() {
        return name;
    }
    String getDescription() {
        return description;
    }
}
