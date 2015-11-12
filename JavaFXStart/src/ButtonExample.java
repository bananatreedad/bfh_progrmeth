import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ButtonExample extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane root = new BorderPane();
		
		final Button button = new Button("Click me");
		root.getChildren().add(button);
		final CheckBox cb1 = new CheckBox("Apple"); root.getChildren().add(cb1);
		final CheckBox cb2 = new CheckBox("Pear"); root.getChildren().add(cb2);
		final ToggleGroup tg = new ToggleGroup();
		final RadioButton rb1 = new RadioButton("Red");
		rb1.setToggleGroup(tg);
		root.getChildren().add(rb1);
		final RadioButton rb2 = new RadioButton("Blue"); rb2.setToggleGroup(tg);
		root.getChildren().add(rb2);
		
		// Set up the stage
		stage.setTitle("JavaFX Example");
		stage.setScene(new Scene(root, 200, 80));

		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
