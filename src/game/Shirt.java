package game;
import java.io.Serializable;

public class Shirt extends Armour implements Serializable {
	private static final long serialVersionUID = 1L;

	public Shirt(String name, int durability, int defenseRating) {
		super(name, durability, defenseRating);
	}
}
