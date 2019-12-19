import java.net.Socket;

public class Room extends Thread {

	private Socket socket1;
	private Socket socket2;

	public Room(Socket socket1, Socket socket2) {
		this.socket1 = socket1;
		this.socket2 = socket2;
	}

	public void run(){
		PlayerThread thread1 = new PlayerThread(socket1, socket2);
		PlayerThread thread2 = new PlayerThread(socket2, socket1);
		thread1.start();
		thread2.start();
	}

	public Socket getSocket1() {
		return socket1;
	}

	public void setSocket1(Socket socket1) {
		this.socket1 = socket1;
	}

	public Socket getSocket2() {
		return socket2;
	}

	public void setSocket2(Socket socket2) {
		this.socket2 = socket2;
	}
}
