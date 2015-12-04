package application.mvc;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ControllerGUI extends Stage {
	
	@SuppressWarnings("unused")
	private final Controller controller;

	public ControllerGUI(Controller controller) {
		this.controller = controller;
		
		HBox box = new HBox();
		box.setSpacing(10);
		box.setPadding(new Insets(20));
		
		Button startButton = new Button("start");
		startButton.setPrefWidth(100);
		Button stopButton = new Button("stop");
		stopButton.setPrefWidth(100);
		Button resetButton = new Button("reset");
		resetButton.setPrefWidth(100);
		
		startButton.setOnAction(event -> controller.start()); 
		stopButton.setOnAction(event -> controller.stop()); 
		resetButton.setOnAction(event -> controller.reset()); 

		box.getChildren().addAll(startButton, stopButton, resetButton);
		
		Scene scene = new Scene(box);
		
		this.setScene(scene);
		this.setTitle("ControllerGUI");
		this.setX(780);
		this.setY(350);
		this.show();
	}
	
	
}
