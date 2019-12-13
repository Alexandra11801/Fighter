package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Shell {

	private IntegerProperty x;
	private IntegerProperty y;
	private IntegerProperty targetX;
	private IntegerProperty targetY;

	public Shell(){
		x = new SimpleIntegerProperty(0);
		y = new SimpleIntegerProperty(0);
		targetX = new SimpleIntegerProperty(0);
		targetY = new SimpleIntegerProperty(0);
	}

	public double targetDistance(){
		return Math.sqrt((x.get() - targetX.get()) * (x.get() - targetX.get()) + (y.get() - targetY.get()) * (y.get() - targetY.get()));
	}

	public int getX() {
		return x.get();
	}

	public IntegerProperty xProperty() {
		return x;
	}

	public void setX(int x) {
		this.x.set(x);
	}

	public int getY() {
		return y.get();
	}

	public IntegerProperty yProperty() {
		return y;
	}

	public void setY(int y) {
		this.y.set(y);
	}

	public int getTargetX() {
		return targetX.get();
	}

	public IntegerProperty targetXProperty() {
		return targetX;
	}

	public void setTargetX(int targetX) {
		this.targetX.set(targetX);
	}

	public int getTargetY() {
		return targetY.get();
	}

	public IntegerProperty targetYProperty() {
		return targetY;
	}

	public void setTargetY(int targetY) {
		this.targetY.set(targetY);
	}

}
