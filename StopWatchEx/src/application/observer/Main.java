package application.observer;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		TimerTeacher timer = new TimerTeacher(100);

		new Stopwatch(timer, 240, 240);
		new AnalogStopwatch(timer);
	}

	public static void main(String[] args) {
		launch(args);
	}
}