package ch.bananenbaum.bbfinanz.view;

import java.io.IOException;

import ch.bananenbaum.bbfinanz.model.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewAccountStage extends Stage {

	public NewAccountStage(Model model) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("NewAccountView.fxml"));

		Parent parent = loader.load();
		
		loader.<NewAccountViewController>getController().init(this, model);

		Scene scene = new Scene(parent);
		this.setTitle("Neues Konto...");
		this.setScene(scene);
		this.show();
	}
}
