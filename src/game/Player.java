package game;

public class Player {

    private String name;
    private int health;
    private Weapon weapon;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.weapon = new Weapon("Rusty Short Sword", 5);
    }

    public String getName() {
        return name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public String toString() {
        return "Player: " + name +
               "\nHealth: " + health +
               "\nWeapon: " + weapon.getName();
    }
}
