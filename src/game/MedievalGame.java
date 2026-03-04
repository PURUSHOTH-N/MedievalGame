package game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class MedievalGame {

	private Player player;

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);
		MedievalGame game = new MedievalGame();

		// Start game (new or load)
		game.player = game.start(console);

		addDelay(1000);
		System.out.println("\nCharacter Ready:");
		System.out.println(game.player);

		// Save test
		addDelay(1000);
		System.out.println("\nSaving game...");
		game.save();

		String savedName = game.player.getName();

		addDelay(1500);
		game.player = null;

		System.out.println("\nReloading save...");
		addDelay(1500);

		game.player = game.load(savedName);

		System.out.println("\nGame Loaded:");
		System.out.println(game.player);

		// 🎮 GAME LOOP
		while (true) {

			System.out.println("\nWhat would you like to do?");
			System.out.println("1. Fight");
			System.out.println("2. Save");
			System.out.println("3. Exit");

			String choice = console.next();

			if (choice.equals("1")) {
				game.battle(console);
			} else if (choice.equals("2")) {
				game.save();
				System.out.println("Game Saved.");
			} else if (choice.equals("3")) {
				System.out.println("Goodbye!");
				break;
			} else {
				System.out.println("Invalid choice.");
			}
		}

		console.close();
	}

	// =========================
	// Start Game
	// =========================
	public Player start(Scanner console) {

		System.out.println("=== MEDIEVAL RPG ===");
		System.out.println("Load saved game? (y/n)");

		String answer = console.next().toLowerCase();

		if (answer.equals("y")) {
			System.out.println("Enter character name:");
			String name = console.next();
			return load(name);
		} else {
			System.out.println("Enter new character name:");
			String name = console.next();
			return new Player(name);
		}
	}

	// =========================
	// Save Game
	// =========================
	public void save() {

		try {
			FileOutputStream fos = new FileOutputStream(player.getName() + ".svr");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(player);

			oos.close();
			fos.close();

		} catch (IOException e) {
			System.out.println("Save failed.");
		}
	}

	// =========================
	// Load Game
	// =========================
	public Player load(String name) {

		try {
			FileInputStream fis = new FileInputStream(name + ".svr");
			ObjectInputStream ois = new ObjectInputStream(fis);

			Player loaded = (Player) ois.readObject();

			ois.close();
			fis.close();

			return loaded;

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Save not found. Creating new character.");
			return new Player(name);
		}
	}

	// =========================
	// Battle System
	// =========================
	public void battle(Scanner console) {

		Enemy enemy = new Enemy();

		System.out.println("\nA wild " + enemy.getName() + " appears!");
		addDelay(1000);

		while (enemy.getHealth() > 0) {

			System.out.println("\nYour HP: " + player.getHealth());
			System.out.println(enemy.getName() + " HP: " + enemy.getHealth());
			System.out.println("Press 'a' to attack.");

			String input = console.next();

			if (input.equalsIgnoreCase("a")) {

				player.attack(enemy);

				if (enemy.getHealth() > 0) {
					System.out.println(enemy.getName() + " attacks you for " + enemy.getDamage() + " damage!");

					player.takeDamage(enemy.getDamage());
				}
			}
		}

		System.out.println("You defeated the " + enemy.getName() + "!");
	}

	// =========================
	// Delay Method
	// =========================
	public static void addDelay(int milliseconds) {

		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}