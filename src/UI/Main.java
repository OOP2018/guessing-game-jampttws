package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 * @author Tanasorn Tritawisup
 */
public class Main extends Application {
	
	public static void main(String[] args) {
		// upper limit for secret number in guessing game		
		launch(args);		
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("GameUI.fxml"));
		GuessingGameController controller = new GuessingGameController();
		loader.setController(controller);
		Parent root = (Parent) loader.load();
		Scene scene = new Scene(root);
		stage.setTitle("Guessing Game");
		stage.setScene(scene);
		stage.show();
		
		int upperBound = 100;
		NumberGame game = new JampttwsGame(upperBound);
		controller.setGame(game);
		
		Count count = new Count();
		game.addObserver(count);
		count.setGame(game);
		count.run();
		
	}
}
