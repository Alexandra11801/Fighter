package sample;

import javafx.application.Platform;

public class DefeatListener extends Thread {

	private Controller controller;
	private Player player;

	public DefeatListener(Controller controller, Player player) {
		this.controller = controller;
		this.player = player;
	}

	public void run(){
		while(player.getHealth() > 0){
			try {
				Thread.sleep(1);
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				controller.defeat();
			}
		});
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
