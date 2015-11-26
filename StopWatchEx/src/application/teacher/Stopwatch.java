package application.teacher;

import javafx.scene.layout.BorderPane;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Stopwatch extends BorderPane {

	private TimerTeacher timer = null;
	private Label timeLabel = new Label("0:00");

	private Button startButton = new Button("Start");
	private Button resetButton = new Button("Reset");
	private Button stopButton = new Button("Stop");

	private Label statusLabel = new Label("Stopped.");

	public Stopwatch() {

		timer = new TimerTeacher(100);
		timer.attach(this);

		HBox labelBox = new HBox(3);
		labelBox.setId("labelBox");

		labelBox.setAlignment(Pos.CENTER);

		Label secLabel = new Label("Sekunden:");

		labelBox.getChildren().addAll(secLabel, timeLabel);

		this.setCenter(labelBox);

		// bottomVBox contains buttonHBox and statusHBox
		VBox bottomVBox = new VBox(2);
		bottomVBox.setPadding(new Insets(3));

		// buttonHBox
		HBox buttonHBox = new HBox(6);
		buttonHBox.setAlignment(Pos.CENTER);

		startButton.setMinWidth(30);
		stopButton.setDisable(true);

		startButton.setMinWidth(70);
		stopButton.setMinWidth(70);
		resetButton.setMinWidth(70);

		buttonHBox.getChildren().addAll(startButton, stopButton, resetButton);

		// statusHBox
		HBox statusHBox = new HBox();
		statusHBox.getChildren().add(statusLabel);

		bottomVBox.getChildren().addAll(buttonHBox, statusHBox);
		this.setBottom(bottomVBox);

		startButton.setOnAction(event -> {
			timer.start();
			this.startButton.setDisable(true);
			this.stopButton.setDisable(false);
			this.resetButton.setDisable(true);
			this.statusLabel.setText("Running...");
		});

		stopButton.setOnAction(event -> {
			timer.stop();
			this.startButton.setDisable(false);
			this.stopButton.setDisable(true);
			this.resetButton.setDisable(false);
			this.statusLabel.setText("Stopped.");
		});

		resetButton.setOnAction(event -> {
			timer.reset();
			this.statusLabel.setText("Resetted.");
		});
	}

	/**
	 * takes the updated second value in milliseconds and sets it to the gui.
	 * 
	 * @param ms
	 */
	public void update() {
		// timeLabel.setText(ms%1000 + ":" + ms%100);
		Platform.runLater(() -> timeLabel.setText(timer.getTimeString()));

	}
}
