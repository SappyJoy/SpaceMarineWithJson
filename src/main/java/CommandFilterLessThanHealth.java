import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class CommandFilterLessThanHealth extends Command {

    Map<Integer, SpaceMarine> lhm;

    public CommandFilterLessThanHealth(Map<Integer, SpaceMarine> lhm) {
        this.name = "filter_less_than_health";
        this.description = "Displays elements whose health field value is less than the specified";
        this.lhm = lhm;
    }

    @Override
    public void execute(Scanner sc) throws FileNotFoundException, IOException {
        float health;
        while (true) {
            try {
                health = sc.nextFloat();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input");
                sc.next();
            }
        }
        for (SpaceMarine spaceMarine : lhm.values()) {
            if (spaceMarine.getHealth() < health)
                System.out.println(spaceMarine);
        }
    }
}
