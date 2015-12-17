
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Model model = new Model();

		new DataEditorStage(model);
		new PieChartStage(model);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
