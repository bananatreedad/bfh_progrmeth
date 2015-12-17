import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class XYChartStage extends Stage {

	public XYChartStage() {

		BorderPane pane = new BorderPane();

		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();

		BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
		barChart.setBarGap(0);
		barChart.setLegendVisible(false);

		ObservableList<XYChart.Data<String, Number>> data = FXCollections.observableArrayList();

		Thread thread = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Platform.runLater(() -> {
					data.get(0).setYValue(data.get(0).getYValue().intValue() + 1);
					System.out.println("written..");
				});
			}
		});

		thread.setDaemon(true);

		thread.start();

		for (int i = 0; i < 6; i++) {
			data.add(i, new XYChart.Data<String, Number>("" + (i + 1), (i + 1) * 10));
		}

		XYChart.Series<String, Number> series = new XYChart.Series<>(data);
		barChart.getData().add(series);

		pane.setCenter(barChart);

		this.setScene(new Scene(pane));
		this.setTitle("XY Chart Example");
		this.show();
	}
}
