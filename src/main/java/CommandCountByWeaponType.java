import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class CommandCountByWeaponType extends Command {

    private Map<Integer, SpaceMarine> lhm;

    public CommandCountByWeaponType(Map<Integer, SpaceMarine> lhm) {
        this.name = "count_by_weapon_type";
        this.description = "Displays the number of elements whose weaponType field value is equal to the specified";
        this.lhm = lhm;
    }

    @Override
    public void execute(Scanner sc) throws FileNotFoundException, IOException {
        Weapon weaponType = Weapon.valueOf(sc.next().toUpperCase());
        int ans = 0;
        for (SpaceMarine spaceMarine : lhm.values()) {
            if (spaceMarine.getWeaponType().equals(weaponType)) {
                ans++;
            }
        }
        System.out.println(ans + " weapon of type " + weaponType);;
    }
}
