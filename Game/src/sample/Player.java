package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.ImageView;

public class Player {

	private IntegerProperty health;
	private ImageView ship;

	public Player() {
		this.health = new SimpleIntegerProperty(15);
	}

	public int getHealth() {
		return health.get();
	}

	public IntegerProperty healthProperty() {
		return health;
	}

	public void setHealth(int health) {
		this.health.set(health);
	}

	public ImageView getShip() {
		return ship;
	}

	public void setShip(ImageView ship) {
		this.ship = ship;
	}
}
