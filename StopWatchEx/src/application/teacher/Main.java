package application.teacher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Stopwatch root = new Stopwatch();

		// Create GUI
		Scene scene = new Scene(root);

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		stage.setTitle("Stopwatch");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}