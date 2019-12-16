package sample;

public class DefeatListener extends Thread {

	private Controller controller;
	private Player player;

	public DefeatListener(Controller controller, Player player) {
		this.controller = controller;
		this.player = player;
	}

	public void run(){
		while(player.getHealth() > 0){System.out.println(player.getHealth());}
		System.out.println(player.getHealth() + ", defeated");
		controller.defeat();
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
