package game;

import java.util.Random;

public class Enemy {

	private String name;
	private int health;
	private int damage;

	public Enemy() {
		Random rand = new Random();

		String[] names = { "Goblin", "Skeleton", "Bandit", "Orc" };
		this.name = names[rand.nextInt(names.length)];

		this.health = rand.nextInt(20) + 20; // 20–40 HP
		this.damage = rand.nextInt(5) + 3; // 3–7 damage
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getDamage() {
		return damage;
	}

	public void takeDamage(int dmg) {
		health -= dmg;
	}
}
