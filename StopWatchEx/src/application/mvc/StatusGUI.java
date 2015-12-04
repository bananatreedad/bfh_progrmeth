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
		
		pane.setPadding(new Insets(50));

		pane.setCenter(statusText);
		
		statusText.setFont(new Font(60));
		
		Scene scene = new Scene(pane);

		this.setScene(scene);
		this.setTitle("StatusGUI");
		this.setX(520);
		this.setY(500);
		this.show();
		
	}

	@Override
	public void update(Observable o, Object arg) {
		this.statusText.setText(timer.isRunning() ? "Running!" : "Stopped.");
	}
}
