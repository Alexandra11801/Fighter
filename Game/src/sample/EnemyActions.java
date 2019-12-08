package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class EnemyActions extends Thread{

	private Socket socket;
	private Controller controller;

	public EnemyActions(Socket socket, Controller controller) {
		this.socket = socket;
		this.controller = controller;
	}

	public void run(){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true){
				String command = br.readLine();
				switch (command){
					case "shoot":
						controller.enemyShoot();
						break;
					case "right":
						controller.enemyGoRight();
						break;
					case "left":
						controller.enemyGoLeft();
						break;
				}
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
}
