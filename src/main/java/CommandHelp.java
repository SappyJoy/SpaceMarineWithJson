import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Command that shows information about every command that user can use
 */
public class CommandHelp extends Command {

    CommandManager commandManager;

    public CommandHelp(CommandManager commandManager) {
        this.name = "help";
        this.description = "Shows info about every command";
        this.commandManager = commandManager;
    }

    @Override
    public void execute(Scanner sc) {
        System.out.println("The options are:\n");
        for (Command cmd : commandManager.getHm().values()) {
            String name = cmd.getName();
            String description = cmd.getDescription();
            System.out.format("%-40s%-150s\n", name, description);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
