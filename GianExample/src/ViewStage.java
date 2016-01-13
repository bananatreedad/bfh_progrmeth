import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewStage extends Stage {

	public ViewStage() throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"));
		
		Parent parent = loader.load();
		
		Scene scene = new Scene(parent);

		this.setScene(scene);
		this.setTitle("GianExample");
		this.show();
	}
}
