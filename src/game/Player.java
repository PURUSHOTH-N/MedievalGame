package game;

import java.util.Scanner;

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

	public Player start(Scanner console) {

		Art.homeScreen();

		System.out.println("Load saved game? (y/n)");
		String answer = console.next().toLowerCase();

		Player player;

		if (answer.equals("y")) {
			System.out.println("Enter name:");
			String name = console.next();
			player = new Player(name); // load later
		} else {
			System.out.println("Enter new character name:");
			String name = console.next();
			player = new Player(name);
		}

		return player;
	}
}
