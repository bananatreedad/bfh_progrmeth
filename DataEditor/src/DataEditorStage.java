import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DataEditorStage extends Stage {

	final Model model;

	public DataEditorStage(Model model) throws IOException {
	
		this.model = model;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DataEditor.fxml"));
		
		Parent parent = loader.load();
		
		loader.<DataEditorController>getController().init(model);

		Scene scene = new Scene(parent);

		this.setScene(scene);
		this.setTitle("Model Editor");
		this.show();
	}
}
