package sample;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Circle;

public class Shell {

	private DoubleProperty x;
	private DoubleProperty y;
	private DoubleProperty targetX;
	private DoubleProperty targetY;
	private Circle shell;

	public Shell(){
		x = new SimpleDoubleProperty(0);
		y = new SimpleDoubleProperty(0);
		targetX = new SimpleDoubleProperty(0);
		targetY = new SimpleDoubleProperty(0);
	}

	public double targetDistance(){
		return Math.sqrt(Math.pow((targetX.get() + 68 / 2.7 - x.get()), 2)  + Math.pow((targetY.get() - y.get()), 2));
	}

	public double getX() {
		return x.get();
	}

	public DoubleProperty xProperty() {
		return x;
	}

	public void setX(double x) {
		this.x.set(x);
	}

	public double getY() {
		return y.get();
	}

	public DoubleProperty yProperty() {
		return y;
	}

	public void setY(double y) {
		this.y.set(y);
	}

	public double getTargetX() {
		return targetX.get();
	}

	public DoubleProperty targetXProperty() {
		return targetX;
	}

	public void setTargetX(double targetX) {
		this.targetX.set(targetX);
	}

	public double getTargetY() {
		return targetY.get();
	}

	public DoubleProperty targetYProperty() {
		return targetY;
	}

	public void setTargetY(double targetY) {
		this.targetY.set(targetY);
	}

	public Circle getShell() {
		return shell;
	}

	public void setShell(Circle shell) {
		this.shell = shell;
	}
}
