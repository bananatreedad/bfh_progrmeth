package bfh.javafx.time;

import java.util.Observable;
import java.util.Observer;

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
import javafx.stage.Stage;

public class DigitalClock extends Stage implements Observer {

	private final Time time;
	private final Label timeLabel;
	private final Button backward;
	private final Button forward;

	public DigitalClock(Time time) {

		this.time = time;
		this.time.addObserver(this);

		final BorderPane root = new BorderPane();
		
		this.timeLabel = new Label("0:00");
		root.setCenter(timeLabel);

		final HBox controls = new HBox(10);
		BorderPane.setMargin(controls, new Insets(5));
		controls.setAlignment(Pos.CENTER);
		root.setBottom(controls);

		this.backward = new Button("<");
		// setOnAction with lambda expression
		this.backward.setOnAction((event) -> {
			this.time.runBackward();
		});
		
		this.forward = new Button(">");
		this.forward.setDisable(true);
		// addEventHandler with lambda expression
		this.forward.addEventHandler(ActionEvent.ACTION, (event) -> {
			this.time.runForward();
		});

		final Button reset = new Button("Reset");
		// setOnAction with anonymous class
		reset.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				time.reset();
			}
		});

		controls.getChildren().addAll(this.backward, this.forward, reset);

		// Setup scene and stage
		Scene scene = new Scene(root, 200, 100);
		this.setTitle("Digital Clock");
		this.setScene(scene);
		this.setX(350);
		this.setY(200);
		this.show();
	}

	@Override
	public void update(Observable o, Object arg) {

		Platform.runLater(() -> {
			String s = String.format("%d:%02d.%02d", time.getHours(), time.getMinutes(), time.getSeconds());
			this.timeLabel.setText(s);

			this.backward.setDisable(!time.isForward());
			this.forward.setDisable(time.isForward());
		});

	}
}