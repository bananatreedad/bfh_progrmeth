package application.observer;

import javafx.scene.layout.BorderPane;

import java.util.Observer;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Stopwatch extends Stage implements Observer {

	private TimerTeacher timer = null;
	private Label timeLabel = new Label("0:00");

	private Button startButton = new Button("Start");
	private Button resetButton = new Button("Reset");
	private Button stopButton = new Button("Stop");

	private Label statusLabel = new Label("Stopped.");

	public Stopwatch(TimerTeacher timer, double posX, double posY) {

		buildGUI(posX, posY);

		addEvents();

		timer.addObserver(this);
		this.timer = timer;
	}

	/**
	 * Builds the GUI.
	 * 
	 */
	private void buildGUI(double posX, double posY) {

		// Create GUI
		BorderPane root = new BorderPane();

		HBox labelBox = new HBox(3);
		labelBox.setId("labelBox");

		labelBox.setAlignment(Pos.CENTER);

		Label secLabel = new Label("Sekunden:");
		labelBox.getChildren().addAll(secLabel, timeLabel);

		root.setCenter(labelBox);

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

		resetButton.disableProperty().bind(startButton.disableProperty());
		stopButton.disableProperty().bind(startButton.disableProperty().not());

		buttonHBox.getChildren().addAll(startButton, stopButton, resetButton);

		// statusHBox
		HBox statusHBox = new HBox();
		statusHBox.getChildren().add(statusLabel);

		bottomVBox.getChildren().addAll(buttonHBox, statusHBox);
		root.setBottom(bottomVBox);

		Scene scene = new Scene(root);

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		this.setTitle("Stopwatch");
		this.setScene(scene);
		this.setX(posX);
		this.setY(posY);
		this.show();
	}

	/**
	 * This function adds the events on the buttons.
	 * 
	 */
	private void addEvents() {

		startButton.setOnAction(event -> {
			timer.start();
		});

		stopButton.setOnAction(event -> {
			timer.stop();
		});

		resetButton.setOnAction(event -> {
			timer.reset();
		});
	}

	@Override
	public void update(java.util.Observable o, Object arg) {
		Platform.runLater(() -> { 
			timeLabel.setText(timer.getTimeString());
			statusLabel.setText(timer.isRunning() ? "Running..." : "Stopped.");
			startButton.setDisable(timer.isRunning());
		});
	}
}
