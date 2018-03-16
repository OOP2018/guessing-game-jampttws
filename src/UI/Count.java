package UI;


import java.util.Observable;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Count implements java.util.Observer{
	
	private Stage stage;
	private Label label;
	private NumberGame game;
	
	public void setGame(NumberGame game){
		this.game = game;
	}
	
	public void initStage() {
		stage = new Stage();
		HBox box = new HBox();
		label = new Label("   ");
		label.setFont(new Font("Arial", 80));
		label.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(box);
		box.getChildren().add(label);
		stage.setScene(scene);
	}
	
	public void run(){
		initStage();
		stage.show();
	}

	@Override
	public void update(Observable o, Object arg) {
		if(arg != null) System.out.println(arg.toString());
		label.setText(Integer.toString(game.getCount()));
		
	}
}
