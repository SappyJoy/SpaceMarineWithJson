import javafx.collections.transformation.SortedList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class CommandPrintFieldAscendingChapter extends Command {

    Map<Integer, SpaceMarine> lhm;

    public CommandPrintFieldAscendingChapter(Map<Integer, SpaceMarine> lhm) {
        this.name = "print_field_ascending";
        this.description = "Print the values of the chapter field of all elements in ascending order";
        this.lhm = lhm;
    }

    @Override
    public void execute(Scanner sc) throws FileNotFoundException, IOException {
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
            System.out.println(sm);
        }
    }
}
