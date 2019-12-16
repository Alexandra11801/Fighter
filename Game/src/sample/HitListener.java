package sample;

public class HitListener extends Thread {

	private Shell shell;
	private Controller controller;

	public HitListener(Shell shell, Controller controller) {
		this.shell = shell;
		this.controller = controller;
	}

	public void run(){
		while(shell.targetDistance() > 7){ }
		shell.getShell().setVisible(false);
		controller.hit();
	}

	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}
}
