import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class XYChartStage extends Stage {

	public XYChartStage(Model model) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("XYChart.fxml"));
		
		Parent root = loader.load();

		loader.<XYChartController>getController().init(model);
		
		Scene scene = new Scene(root);

		this.setTitle("XYChart");
		this.setScene(scene);
		this.show();
	}
}
