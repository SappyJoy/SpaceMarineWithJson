import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * Command that displays the number of elements whose weaponType field value is equal to the specified
 */
public class CommandCountByWeaponType extends Command {

    private Map<Integer, SpaceMarine> lhm;

    public CommandCountByWeaponType(Map<Integer, SpaceMarine> lhm) {
        this.name = "count_by_weapon_type";
        this.description = "Displays the number of elements whose weaponType field value is equal to the specified";
        this.lhm = lhm;
    }

    @Override
    public void execute(Scanner sc) {
        String value;
        Weapon weaponType;
        while (true) {
            try {
                value = sc.next();
                weaponType = Weapon.valueOf(value.toUpperCase());
                break;
            } catch (InputMismatchException | EnumConstantNotPresentException e) {
                System.out.println("Wrong input");
            }
        }

        int ans = 0;
        for (SpaceMarine spaceMarine : lhm.values()) {
            if (spaceMarine.getWeaponType().equals(weaponType)) {
                ans++;
            }
        }
        System.out.println(ans + " weapon of type " + weaponType);;
    }
}
