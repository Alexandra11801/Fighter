package sample;

import javafx.animation.*;
import javafx.fxml.*;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.PrintWriter;

public class Controller {

	private Player you;
	private Player enemy;
	@FXML private TextField yourHealth;
	@FXML private TextField enemyHealth;
	@FXML private ImageView yourShip;
	@FXML private ImageView enemyShip;
	@FXML private AnchorPane pane;
	private PrintWriter writer;

	@FXML
	public void initialize(){
		you = new Player();
		enemy = new Player();
		yourHealth.textProperty().bind(you.healthProperty().asString());
		enemyHealth.textProperty().bind(enemy.healthProperty().asString());
		Main.setController(this);
	}


	public void shoot(){
		writer.println("shoot");
		Circle shell = new Circle(2, Color.RED);
		shell.setCenterX(yourShip.getLayoutX() + yourShip.getFitWidth() / 2.7);
		shell.setCenterY(yourShip.getLayoutY());
		pane.getChildren().addAll(shell);
		KeyValue kv = new KeyValue(shell.centerYProperty(), shell.getCenterY() - 300);
		KeyFrame kf = new KeyFrame(Duration.seconds(5), kv);
		Timeline tm = new Timeline(kf);
		tm.setOnFinished(event -> {
			shell.setVisible(false);
		});
		tm.play();
	}

	public void goRight(){
		writer.println("right");
		KeyValue kv = new KeyValue(yourShip.layoutXProperty(), yourShip.getLayoutX() + 20);
		KeyFrame kf = new KeyFrame(Duration.seconds(0.1), kv);
		Timeline tm = new Timeline(kf);
		tm.play();
	}

	public void goLeft(){
		writer.println("left");
		KeyValue kv = new KeyValue(yourShip.layoutXProperty(), yourShip.getLayoutX() - 20);
		KeyFrame kf = new KeyFrame(Duration.seconds(0.1), kv);
		Timeline tm = new Timeline(kf);
		tm.play();
	}

	public void enemyShoot(){
		Circle shell = new Circle(2, Color.RED);
		shell.setCenterX(enemyShip.getLayoutX() + enemyShip.getFitWidth() / 2.7);
		shell.setCenterY(enemyShip.getLayoutY() + enemyShip.getFitHeight());
		pane.getChildren().addAll(shell);
		Shell sh = new Shell();
		sh.xProperty().bindBidirectional(shell.centerXProperty());
		sh.yProperty().bindBidirectional(shell.centerYProperty());
		sh.targetXProperty().bindBidirectional(yourShip.layoutXProperty());
		sh.targetYProperty().bindBidirectional(yourShip.layoutYProperty());
		HitListener hl = new HitListener(sh, this);
		hl.start();
		KeyValue kv = new KeyValue(shell.centerYProperty(), shell.getCenterY() + 300);
		KeyFrame kf = new KeyFrame(Duration.seconds(5), kv);
		Timeline tm = new Timeline(kf);
		tm.setOnFinished(event -> {
			shell.setVisible(false);
		});
		tm.play();
	}

	public void enemyGoRight(){
		KeyValue kv = new KeyValue(enemyShip.layoutXProperty(), enemyShip.getLayoutX() + 20);
		KeyFrame kf = new KeyFrame(Duration.seconds(0.1), kv);
		Timeline tm = new Timeline(kf);
		tm.play();
	}

	public void enemyGoLeft(){
		KeyValue kv = new KeyValue(enemyShip.layoutXProperty(), enemyShip.getLayoutX() - 20);
		KeyFrame kf = new KeyFrame(Duration.seconds(0.1), kv);
		Timeline tm = new Timeline(kf);
		tm.play();
	}

	public void hit(){
		you.setHealth(you.getHealth() - 1);
	}

	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}
}
