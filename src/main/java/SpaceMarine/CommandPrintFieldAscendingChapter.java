package SpaceMarine;

import java.util.*;

/**
 * SpaceMarine.Command that prints the values of the chapter field of all elements in ascending order
 */
public class CommandPrintFieldAscendingChapter extends Command {

    Map<Integer, SpaceMarine> lhm;

    public CommandPrintFieldAscendingChapter(Map<Integer, SpaceMarine> lhm) {
        this.name = "print_field_ascending_chapter";
        this.description = "Print the values of the chapter field of all elements in ascending order";
        this.lhm = lhm;
    }

    @Override
    public void execute(Scanner sc) {
        ArrayList<SpaceMarine> sortByChapter = new ArrayList<>(lhm.values());
        Comparator<SpaceMarine> comparator = new Comparator<SpaceMarine>() {
            @Override
            public int compare(SpaceMarine spaceMarine, SpaceMarine t1) {
                Chapter chapter1 = spaceMarine.getChapter();
                Chapter chapter2 = t1.getChapter();
                return chapter1.compareTo(chapter2);
            }
        };
        sortByChapter.sort(comparator);
        for (SpaceMarine sm : sortByChapter) {
            System.out.println(sm.getChapter());
        }
    }
}
