package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class Main extends Application {

	private static Controller controller;
	private Socket socket;
	private final String host = "localhost";
	private final int port = 1234;

    @Override
    public void start(Stage primaryStage) throws Exception{
	    socket = new Socket(host, port);
	    while(!(new BufferedReader(new InputStreamReader(socket.getInputStream()))).readLine().equals("start")){}
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Fighter");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setWidth(600);
        primaryStage.setHeight(500);
        primaryStage.show();
	    primaryStage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
		    @Override
		    public void handle(KeyEvent event) {
			    if(event.getCode().equals(KeyCode.SPACE)){
				    controller.shoot();
			    }
			    if(event.getCode().equals(KeyCode.RIGHT)){
			    	controller.goRight();
			    }
			    if(event.getCode().equals(KeyCode.LEFT)){
				    controller.goLeft();
			    }
		    }
	    });
	    controller.setWriter(new PrintWriter(new BufferedOutputStream(socket.getOutputStream()), true));
	    EnemyActions ea = new EnemyActions(socket, controller);
	    ea.start();
    }

    public static void main(String[] args) {
        launch(args);
    }

	public static void setController(Controller c) {
		controller = c;
	}
}
