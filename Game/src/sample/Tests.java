package sample;

import javafx.scene.control.TextField;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class Tests {

	@Test
	public void InitialHealthIsEqual15(){
		Assert.assertEquals(15, (new Player()).getHealth());
	}

	@Test
	public void InitialPlayerNotNull(){
		Controller controller = new Controller();
		controller.initializeWithoutBinding();
		Assert.assertNotEquals(null, controller.getYou());
	}

	@Test
	public void InitialEnemyNotNull(){
		Controller controller = new Controller();
		controller.initializeWithoutBinding();
		Assert.assertNotEquals(null, controller.getEnemy());
	}


	@Test
	public void HitDecreasesHealth(){
		Player enemy = new Player();
		Controller controller = mock(Controller.class);
		when(controller.getEnemy()).thenReturn(enemy);
		controller.enemyHit();
		Assert.assertEquals(14, controller.getEnemy().getHealth());
	}
}
