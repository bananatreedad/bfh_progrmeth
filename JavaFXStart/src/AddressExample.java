
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AddressExample extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		
		VBox vBox = new VBox(3);

		Label adress = new Label("Address");
		adress.setFont(Font.font(null, FontWeight.BOLD, -1));

		vBox.getChildren().add(adress);
		
		GridPane grid = new GridPane();
		
		grid.setHgap(15);
		grid.setVgap(3);

		grid.setAlignment(Pos.CENTER);

		Label name = new Label("Name");
		GridPane.setConstraints(name, 0, 0);

		Label preName = new Label("Prename");
		GridPane.setConstraints(preName, 0, 1);

		Label street = new Label("Street");
		GridPane.setConstraints(street, 0, 2);

		Label plz = new Label("PLZ");
		GridPane.setConstraints(plz, 0, 3);

		Label city = new Label("City");
		GridPane.setConstraints(city, 2, 3);

		TextField nameField = new TextField();
		GridPane.setConstraints(nameField, 1, 0, GridPane.REMAINING, 1);

		TextField preNameField = new TextField();
		GridPane.setConstraints(preNameField, 1, 1, GridPane.REMAINING, 1);

		TextField streetField = new TextField();
		GridPane.setConstraints(streetField, 1, 2, GridPane.REMAINING, 1);

		TextField plzField = new TextField();
		plzField.setPrefWidth(50);

		GridPane.setConstraints(plzField, 1, 3, 1, 1);

		TextField cityField = new TextField();
		GridPane.setConstraints(cityField, 3, 3, GridPane.REMAINING, 1);

		grid.getChildren().addAll(name, preName, street, plz, city, nameField, preNameField, streetField, plzField,
				cityField);

		
		HBox buttonBox = new HBox(10);
		buttonBox.setAlignment(Pos.CENTER_RIGHT);
		Button okButton = new Button("OK");
		okButton.setMinWidth(70);

		Button cancelButton = new Button("Cancel");
		cancelButton.setMinWidth(70);

		buttonBox.getChildren().addAll(okButton, cancelButton);

		vBox.getChildren().addAll(grid, buttonBox);
		
		pane.setCenter(vBox);


		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Address");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
