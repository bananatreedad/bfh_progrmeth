
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GridExample extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		GridPane grid = new GridPane();

		grid.setVgap(5);
		grid.setHgap(15);
		
		Label login = new Label("login");
		GridPane.setConstraints(login, 0, 0, 1, 1);
		
		TextField loginField = new TextField();
		GridPane.setConstraints(loginField, 1, 0, GridPane.REMAINING, 1);
		
		GridPane.setConstraints(loginField, 0, 1, GridPane.REMAINING, 1);
		
		grid.getChildren().addAll(login, loginField);
		
		Scene scene = new Scene(grid);

		primaryStage.setScene(scene);
		primaryStage.setTitle("GridTest");

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
