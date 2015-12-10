import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PieChartStage extends Stage {

	public PieChartStage() {
		
		BorderPane root = new BorderPane();
		
		
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Windows", 0.5),
				new PieChart.Data("Temple OS", 15),
				new PieChart.Data("Mac OSX", 60));
		
		PieChart pieChart = new PieChart(pieChartData);

		pieChart.setClockwise(true);
		pieChart.setLegendVisible(false);		

		root.setCenter(pieChart);
		this.setScene(new Scene(root));
		this.setTitle("PieChart Example");
		this.show();
	}
}
