import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

/**
 * Shows info about collection
 */
public class CommandInfo extends Command {

    Map<Integer, SpaceMarine> lhm;

    public CommandInfo(Map<Integer, SpaceMarine> lhm) {
        this.name = "info";
        this.description = "Display information about your collection";
        this.lhm = lhm;
    }

    @Override
    public void execute(Scanner sc) {
        String typeOfCollection = lhm.getClass().getSimpleName();
        java.time.LocalDateTime creationDate = LocalDateTime.MAX;
        for (SpaceMarine spaceMarine : lhm.values()) {
            if (creationDate.compareTo(spaceMarine.getCreationDate()) > 0)
                creationDate = spaceMarine.getCreationDate();
        }
        int sizeOfCollection = lhm.size();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        String formattedCreationDate = creationDate.format(formatter);

        System.out.printf("\tType of collection: %s\n\tInitialization date: %s\n\tSize of collection: %d\n",
                typeOfCollection, formattedCreationDate, sizeOfCollection);
    }
}
