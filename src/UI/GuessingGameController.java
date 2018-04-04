package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;


/**
 * Controller for the Counter buttons user interface.
 * @author Tanasorn Tritawisup
 *
 */
public class GuessingGameController {
	
	@FXML
	TextField textfield;
	@FXML
	Button button;
	@FXML
	Label label;
	
	private NumberGame game;
	
	public void setGame(NumberGame nGame){
		this.game = nGame;
	}
	
	public void gameHandle(ActionEvent event) {
		int number = Integer.parseInt(textfield.getText());
		if(game.guess(number)){
			label.setText(game.getMessage());
			Alert message = new Alert(AlertType.INFORMATION);
			message.setTitle("You win!!");
			message.setHeaderText(null);
			message.setContentText("the number is " + number);
			message.showAndWait();
		} else {
			label.setText(game.getMessage());
		}		
	}
	
	
}
