package ch.bnnb.ownclock;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OwnClockStage extends Stage {

	public OwnClockStage(OwnClock clock) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("OwnClockStageView.fxml"));
		
		Parent parent = loader.load();
		
		OwnClockStageController controller = (OwnClockStageController) loader.getController();
		controller.setClock(clock);

		Scene scene = new Scene(parent);
		this.setScene(scene);
		this.show();
	}
}
