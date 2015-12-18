import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PieChartStage extends Stage {
	
	final Model model;
	
	public PieChartStage(Model model) throws IOException {
		
		this.model = model;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("PieChart.fxml"));

		Parent root = loader.load();
		loader.<PieChartController>getController().init(model);
		
		Scene scene = new Scene(root);
		this.setX(100);
		this.setY(100);
		
		this.setTitle("Pie Chart");
		this.setScene(scene);
		this.show();

	}

}
