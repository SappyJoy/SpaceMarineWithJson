import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Scanner;

public class SpaceMarine implements Cloneable, Comparable<SpaceMarine> {
    /**
     * @param
     */
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float health; //Значение поля должно быть больше 0
    private boolean loyal;
    private Weapon weaponType = null; //Поле может быть null
    private MeleeWeapon meleeWeapon = null; //Поле может быть null
    private Chapter chapter; //Поле не может быть null

    public SpaceMarine(String name, Coordinates coordinates, float health, boolean loyal, Weapon weaponType,
                       MeleeWeapon meleeWeapon, Chapter chapter) {
        this();
        this.id = name.hashCode();
        this.name = name;
        this.coordinates = coordinates;
        this.health = health;
        this.loyal = loyal;
        this.weaponType = weaponType;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
    }

    public SpaceMarine(String name, Coordinates coordinates, java.time.LocalDateTime creationDate, float health,
                       boolean loyal, Weapon weaponType, MeleeWeapon meleeWeapon, Chapter chapter) {
        this(name, coordinates, health, loyal, weaponType, meleeWeapon, chapter);
        this.creationDate = creationDate;
    }

    public SpaceMarine() {
        creationDate = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getHealth() {
        return health;
    }

    public Weapon getWeaponType() {
        return weaponType;
    }

    public Chapter getChapter() {
        return chapter;
    }

    void scan(Scanner sc) {
        System.out.print("\tInput a name: ");
        name = sc.next();
        id = name.hashCode();
        System.out.print("\tInput coordinates(x, y): ");
        coordinates = new Coordinates(sc.nextLong(), sc.nextLong());
        System.out.print("\tInput health: ");
        health = sc.nextFloat();
        System.out.print("\tInput loyal(true or false): ");
        loyal = sc.nextBoolean();
        System.out.print("\tInput weapon type\n\t" +
                "(PLASMA_GUN, COMBI_PLASMA_GUN, FLAMER, INFERNO_PISTOL, HEAVY_FLAMER): ");
        weaponType = Weapon.valueOf(sc.next().toUpperCase());
        System.out.print("\tInput melee weapon(CHAIN_SWORD, CHAIN_AXE, POWER_BLADE): ");
        meleeWeapon = MeleeWeapon.valueOf(sc.next().toUpperCase());
        System.out.print("\tInput chapter(name, count of marines and world): ");
        chapter = new Chapter(sc.next(), sc.nextInt(), sc.next());
    }



    @Override
    public String toString() {
        return "\"SpaceMarine\":{" +
                "\"id\":" + id +
                ", \"name\":\"" + name + '\"' +
                ", \"coordinates\":" + coordinates +
                ", \"creationDate\":\"" + creationDate +
                "\", \"health\":" + health +
                ", \"loyal\":" + loyal +
                ", \"weaponType\":\"" + weaponType +
                "\", \"meleeWeapon\":\"" + meleeWeapon +
                "\", \"chapter\":" + chapter +
                '}';
    }

    @Override
    public int compareTo(SpaceMarine spaceMarine) {
        return id - spaceMarine.id;
    }
}

