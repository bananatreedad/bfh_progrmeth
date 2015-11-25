package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	private Thread thread = null;
	private int secs = 0;

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane root = new BorderPane();

		HBox labelBox = new HBox(3);
		labelBox.setId("labelBox");

		labelBox.setAlignment(Pos.CENTER);

		Label secLabel = new Label("Sekunden:");
		Label timeLabel = new Label("0:00");

		labelBox.getChildren().addAll(secLabel, timeLabel);

		root.setCenter(labelBox);

		// bottomVBox contains buttonHBox and statusHBox
		VBox bottomVBox = new VBox(2);
		bottomVBox.setPadding(new Insets(3));

		// buttonHBox
		HBox buttonHBox = new HBox(6);
		buttonHBox.setAlignment(Pos.CENTER);

		Button startButton = new Button("Start");
		startButton.setMinWidth(30);
		Button stopButton = new Button("Stop");
		stopButton.setDisable(true);

		startButton.setOnAction((event) -> {

			Platform.runLater(() -> {
				while (true) {
					timeLabel.setText(secs / 60 + ":" + secs % 60);

					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}

					secs++;
				}
			});
		});

		Button resetButton = new Button("Reset");
		startButton.setMinWidth(70);
		stopButton.setMinWidth(70);
		resetButton.setMinWidth(70);

		buttonHBox.getChildren().addAll(startButton, stopButton, resetButton);

		// statusHBox
		HBox statusHBox = new HBox();
		Label statusLabel = new Label("Stopped");
		statusHBox.getChildren().add(statusLabel);

		bottomVBox.getChildren().addAll(buttonHBox, statusHBox);
		root.setBottom(bottomVBox);

		// Create GUI
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		stage.setTitle("StopWatch");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}