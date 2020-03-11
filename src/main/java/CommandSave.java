import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class CommandSave extends Command {
    /**
     * Сохраняет коллекцию в файл в виде toString()
     */
    Map<Integer, SpaceMarine> lhm;
    File file;

    public CommandSave(Map<Integer, SpaceMarine> lhm, File file) {
        this.name = "save";
        this.description = "Saves the collection to a file";
        this.lhm = lhm;
        this.file = file;
    }

    @Override
    public void execute(Scanner sc) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(file);
        pw.flush();
        if (!lhm.isEmpty()) {
            pw.write("{\"array\":[");
            int j = 0;
            for (int i : lhm.keySet()) {
                pw.write("{\"key\":" + i + "," + lhm.get(i) + "}");
                if (j != lhm.size()-1)
                    pw.write(",\n");
                else
                    pw.write("]}");
                j++;
            }
        }
        pw.close();
    }
}
