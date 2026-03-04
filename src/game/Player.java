package game;

import java.io.Serializable;

public class Player implements Serializable {
	private static final long serialVersionUID = 1L;

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

	public void takeDamage(int damage) {
		health -= damage;
		if (health <= 0) {
			System.out.println("You have died.");
			System.exit(0);
		}
	}

	public void heal(int amount) {
		health += amount;
		if (health > 100) {
			health = 100;
		}
	}

	public int getHealth() {
		return health;
	}



	public void attack(Enemy enemy) {
		int damage = weapon.getDamage();
		System.out.println("You attack the " + enemy.getName() + " for " + damage + " damage!");
		enemy.takeDamage(damage);
	}
}
