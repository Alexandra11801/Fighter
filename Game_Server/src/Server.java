import java.io.*;
import java.net.*;

public class Server {

	private static final int port = 1234;

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(port);
		while (true){
			Socket socket1 = serverSocket.accept();
			Socket socket2 = serverSocket.accept();
			Room room = new Room(socket1, socket2);
			room.start();
		}
	}

}
