package game;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class MedievalGame {

	public Player start(Scanner console) {
		return null;
	}

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		MedievalGame game = new MedievalGame();
		game.start(console);
	}

	private Player player;

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
}
