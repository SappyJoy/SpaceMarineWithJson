import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;

public class WorkWithJson {
    File file;
    FileInputStream fis;
    String str;
    LinkedHashMap<Integer, SpaceMarine> lhm;

    public WorkWithJson(File file) throws IOException {
        this.file = file;
        fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();

        str = new String(data, "UTF-8");
        lhm = new LinkedHashMap<>();
        makeMapFromJsonString(str);
    }

    public LinkedHashMap<Integer, SpaceMarine> getLhm() {
        return lhm;
    }

    private void makeMapFromJsonString(String str) {
        if (!str.isEmpty()) {
            JSONObject jsonObject = new JSONObject(str);
            JSONArray mapArray = jsonObject.getJSONArray("array");
            for (int i = 0; i < mapArray.length(); i++) {
                String jsonSMString = mapArray.get(i).toString();
                JSONObject jsonKeyValue = new JSONObject(jsonSMString);
                int key = jsonKeyValue.getInt("key");

                jsonSMString = jsonKeyValue.get("SpaceMarine").toString();
                JSONObject jsonSM = new JSONObject(jsonSMString);
                String name = jsonSM.getString("name");

                String jsonSMCoordinatesString = jsonSM.get("coordinates").toString();
                JSONObject jsonCoordinates = new JSONObject(jsonSMCoordinatesString);
                int x = jsonCoordinates.getInt("x");
                int y = jsonCoordinates.getInt("y");
                Coordinates coordinates = new Coordinates(x, y);

                java.time.LocalDateTime creationDate = LocalDateTime.parse(jsonSM.get("creationDate").toString());

                float health = jsonSM.getFloat("health");

                boolean loyal = jsonSM.getBoolean("loyal");

                Weapon weaponType = Weapon.valueOf(jsonSM.getString("weaponType"));

                MeleeWeapon meleeWeapon = MeleeWeapon.valueOf(jsonSM.getString("meleeWeapon"));

                String jsonSMChapterString = jsonSM.get("chapter").toString();
                JSONObject jsonChapter = new JSONObject(jsonSMChapterString);
                String nameChapter = jsonChapter.getString("name");
                int marinesCount = jsonChapter.getInt("marinesCount");
                String world = jsonChapter.getString("world");
                Chapter chapter = new Chapter(nameChapter, marinesCount, world);

                SpaceMarine spaceMarine = new SpaceMarine(name, coordinates, creationDate, health, loyal, weaponType, meleeWeapon, chapter);

                lhm.put(key, spaceMarine);
            }
        }
    }
}
