package ch.bnntd.pgmmtd.mailclient;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MailClientStage extends Stage {

	public MailClientStage() throws IOException {
		
		System.out.println(getClass().getResource("MailClient.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("MailClient.fxml"));
		
		Scene scene = new Scene(root);
		this.setScene(scene);
		this.setTitle("Mail Client");
		this.show();
	}

}
