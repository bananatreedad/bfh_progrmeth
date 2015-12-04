package application.mvc;

import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StatusGUI extends Stage implements Observer {
	
	final private TimerTeacher timer;
	final Text statusText = new Text("Stopped.");
	
	public StatusGUI(TimerTeacher timer) {
		
		this.timer = timer;
		timer.addObserver(this);
		
		BorderPane pane = new BorderPane();
		pane.getStyleClass().add("background");
		
		pane.setPadding(new Insets(50));

		pane.setCenter(statusText);
		
		statusText.setFont(new Font(60));
		statusText.getStyleClass().addAll("statusText", "deactive");

		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		this.setScene(scene);
		this.setTitle("StatusGUI");
		this.setX(520);
		this.setY(500);
		this.show();
		
		System.out.println(this.statusText.getStyleClass());
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if(timer.isRunning()) {
			this.statusText.setText("Running!");
			if(this.statusText.getStyleClass().contains("deactive")) {
				this.statusText.getStyleClass().remove("deactive");
				this.statusText.getStyleClass().add("active");
			}
		}
		else {
			this.statusText.setText("Stopped.");
			if(this.statusText.getStyleClass().contains("active")) {
				this.statusText.getStyleClass().remove("active");
				this.statusText.getStyleClass().add("deactive");
			}
		};
	}
}
