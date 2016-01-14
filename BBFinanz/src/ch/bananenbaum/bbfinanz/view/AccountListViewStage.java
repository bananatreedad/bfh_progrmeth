package ch.bananenbaum.bbfinanz.view;

import java.io.IOException;

import ch.bananenbaum.bbfinanz.model.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AccountListViewStage extends Stage {
	
	final Model model;
	
	public AccountListViewStage(Model model) throws IOException {
		
		this.model = model;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountListView.fxml"));
		
		Parent parent = loader.load();
		
		loader.<AccountViewController>getController().init(model);
		
		Scene scene = new Scene(parent);

		this.setScene(scene);
		this.setX(200);
		this.setY(200);
		this.setTitle("Kontenübersicht");
		this.show();

	}
}
