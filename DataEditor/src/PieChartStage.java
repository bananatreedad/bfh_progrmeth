import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PieChartStage extends Stage {
	
	final Model model;
	
	public PieChartStage(Model model) {
		
		this.model = model;

		BorderPane root = new BorderPane();
		
		Scene scene = new Scene(root);
		
		this.setScene(scene);
		this.show();

	}

}
