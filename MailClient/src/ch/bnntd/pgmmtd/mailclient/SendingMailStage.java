package ch.bnntd.pgmmtd.mailclient;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SendingMailStage extends Stage {
	
	public SendingMailStage(boolean mailSuccess, String errorMessage) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SendingMail.fxml"));

		Parent root = loader.load();

		loader.<SendingMailController>getController().init(this, mailSuccess, errorMessage);
		
		this.setScene(new Scene(root));
		this.setTitle("sending");
		this.initModality(Modality.APPLICATION_MODAL);
		this.show();
	}
}
