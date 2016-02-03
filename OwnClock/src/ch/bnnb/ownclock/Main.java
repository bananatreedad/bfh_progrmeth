package ch.bnnb.ownclock;

import java.util.Date;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		OwnClock clock = new OwnClock(new Date(0));
		
		ConsoleOwnClock consoleClock = new ConsoleOwnClock(clock);
	}
}
