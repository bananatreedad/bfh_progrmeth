import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFXExample extends Application {
	@Override
	public void start(Stage stage) throws Exception {

		BorderPane root = new BorderPane();
		HBox hbox = new HBox(5);
		root.setCenter(hbox);

		// Create a label and a text field and add them to the scene graph
		Label l = new Label("Name");
		hbox.setAlignment(Pos.CENTER_LEFT);
		l.setMinWidth(40);
		TextField t = new TextField();
		hbox.getChildren().addAll(l, t);

		// Create a button and add it to the scene graph
		Button b = new Button("Quit");
		b.setOnAction((e) -> System.exit(0));
		
		b.setPrefWidth(Double.MAX_VALUE);
		root.setPadding(new Insets(2));
		
		root.setBottom(b);

		// Set up the stage
		stage.setTitle("JavaFX Example");
		stage.setScene(new Scene(root, 200, 80));

		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}