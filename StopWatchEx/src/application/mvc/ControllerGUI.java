package application.mvc;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ControllerGUI extends Stage {

	@SuppressWarnings("unused")
	private final Controller controller;

	public ControllerGUI(Controller controller) {
		this.controller = controller;

		BorderPane pane = new BorderPane();
		pane.getStyleClass().add("background");

		HBox box = new HBox();
		pane.setCenter(box);

		box.setSpacing(10);
		box.setPadding(new Insets(20));

		Button startButton = new Button("start");
		startButton.setPrefWidth(100);
		Button stopButton = new Button("stop");
		stopButton.setPrefWidth(100);
		Button resetButton = new Button("reset");
		resetButton.setPrefWidth(100);

		MenuBar menuBar = new MenuBar();
		Menu appMenu = new Menu("Application");
		MenuItem closeItem = new MenuItem("Close");
		appMenu.getItems().add(closeItem);
		Menu stopwatchMenu = new Menu("Stopwatch");
		MenuItem newStopwatchItem = new MenuItem("New Stopwatch");
		stopwatchMenu.getItems().add(newStopwatchItem);

		stopwatchMenu.setOnAction(event -> {

			TimerTeacher newTimer = new TimerTeacher(100);
			Controller newController = new Controller(newTimer);

			new Stopwatch(newTimer, newController, 0, 0);

		});

		closeItem.setOnAction(event -> System.exit(0));

		menuBar.getMenus().addAll(appMenu, stopwatchMenu);
		pane.setTop(menuBar);

		startButton.setOnAction(event -> controller.start());
		stopButton.setOnAction(event -> controller.stop());
		resetButton.setOnAction(event -> controller.reset());

		box.getChildren().addAll(startButton, stopButton, resetButton);

		Scene scene = new Scene(pane);

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		this.setScene(scene);
		this.setTitle("ControllerGUI");
		this.setX(780);
		this.setY(350);
		this.show();
	}

}
