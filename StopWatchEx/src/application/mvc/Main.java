package application.mvc;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		TimerTeacher timer = new TimerTeacher(100);
		Controller controller = new Controller(timer);

		new Stopwatch(timer, controller, 240, 240);
		new AnalogStopwatch(timer);
		new ControllerGUI(controller);
	}

	public static void main(String[] args) {
		launch(args);
	}
}