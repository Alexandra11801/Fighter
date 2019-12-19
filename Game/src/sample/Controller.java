package sample;

import javafx.animation.*;
import javafx.fxml.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
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
		DefeatListener dl = new DefeatListener(this, you);
		dl.start();
		Main.setController(this);
	}

	public void initializeWithoutBinding(){
		you = new Player();
		enemy = new Player();
		DefeatListener dl = new DefeatListener(this, you);
		dl.start();
		Main.setController(this);
	}

	public void shoot(){
		writer.println("shoot");
		Circle shell = new Circle(2, Color.RED);
		shell.setCenterX(yourShip.getLayoutX() + yourShip.getFitWidth() / 2.7);
		shell.setCenterY(yourShip.getLayoutY());
		pane.getChildren().addAll(shell);
		HitListener hl = new HitListener(this, shell, enemyShip);
		hl.start();
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
		try {
			HitListener hl = new HitListener(this, shell, yourShip, this.getClass().getMethod("hit"));
			hl.start();
		}
		catch (NoSuchMethodException e){
			e.printStackTrace();
		}
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
		if(you.getHealth() > 0) {
			writer.println("hit");
			you.setHealth(you.getHealth() - 1);
		}
	}

	public void enemyHit(){
		enemy.setHealth(enemy.getHealth() - 1);
	}

	public void defeat(){
		Main.isEnded(true);
		writer.println("defeated");
		Label label = new Label("You lost!");
		label.setPrefWidth(200);
		label.setPrefHeight(50);
		label.setFont(new Font(47));
		label.setLayoutX(95);
		label.setLayoutY(100);
		pane.getChildren().addAll(label);
	}

	public void enemyDefeat(){
		Main.isEnded(true);
		Label label = new Label("You won!");
		label.setPrefWidth(200);
		label.setPrefHeight(50);
		label.setFont(new Font(47));
		label.setLayoutX(95);
		label.setLayoutY(100);
		pane.getChildren().addAll(label);
	}

	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}

	public Player getYou(){
		return you;
	}
	public Player getEnemy(){
		return enemy;
	}

}
