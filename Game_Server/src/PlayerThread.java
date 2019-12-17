import java.io.*;
import java.net.Socket;

public class PlayerThread extends Thread {

	private Socket playerSocket;
	private Socket enemySocket;

	public PlayerThread(Socket playerSocket, Socket enemySocket) {
		this.playerSocket = playerSocket;
		this.enemySocket = enemySocket;
	}

	public void run(){
		try {
			PrintWriter pw = new PrintWriter(new BufferedOutputStream(enemySocket.getOutputStream()), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(playerSocket.getInputStream()));
			pw.println("start");
			while (true) {
				String command = br.readLine();
				switch (command) {
					case "shoot":
						pw.println("shoot");
						break;
					case "right":
						pw.println("left");
						break;
					case "left":
						pw.println("right");
						break;
					case "hit":
						pw.println("hit");
						break;
					case "defeated":
						pw.println("defeated");
						break;
				}
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	public Socket getPlayerSocket() {
		return playerSocket;
	}

	public void setSocket(Socket playerSocket) {
		this.playerSocket = playerSocket;
	}

	public Socket getEnemySocket() {
		return enemySocket;
	}

	public void setEnemySocket(Socket enemySocket) {
		this.enemySocket = enemySocket;
	}
}
