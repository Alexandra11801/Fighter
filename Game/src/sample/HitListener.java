package sample;

import javafx.scene.Node;
import javafx.scene.shape.Circle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HitListener extends Thread {

	private Controller controller;
	private Circle shell;
	private Node target;
	private Method method;

	public HitListener(Controller controller, Circle shell, Node target, Method method) {
		this.controller = controller;
		this.shell = shell;
		this.target = target;
		this.method = method;
	}

	public HitListener(Controller controller, Circle shell, Node target) {
		this.controller = controller;
		this.shell = shell;
		this.target = target;
		this.method = null;
	}

	public void run(){
		while(shell.isVisible()) {
			if(shell.intersects(target.getBoundsInParent())) {
				shell.setVisible(false);
				if (method != null) {
					try {
						method.invoke(controller);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public Circle getShell() {
		return shell;
	}

	public void setShell(Circle shell) {
		this.shell = shell;
	}

	public Node getTarget() {
		return target;
	}

	public void setTarget(Node target) {
		this.target = target;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}
}
