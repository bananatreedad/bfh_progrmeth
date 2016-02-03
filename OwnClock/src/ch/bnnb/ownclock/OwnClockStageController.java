package ch.bnnb.ownclock;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class OwnClockStageController implements Observer {

	@FXML
	private Text text_time;
	
	private OwnClock clock;

	@FXML
	private void initialize() {
		System.out.println("teeest!");
	}
	
	public void setClock(OwnClock clock) {
		this.clock = clock;
		clock.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				System.out.println("ololol");
				text_time.setText(Long.toString((long) arg));

			}
		});
	}
}
