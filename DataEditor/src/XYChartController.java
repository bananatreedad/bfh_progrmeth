import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

public class XYChartController implements Observer {

	Model model = null;
	ObservableList<XYChart.Data<String, Integer>> data = FXCollections.observableArrayList();

	@FXML
	private CategoryAxis xAxis;

	@FXML
	private NumberAxis yAxis;

	@FXML
	private BarChart<String, Integer> barChart;

	@FXML
	private void initialize() {
		System.out.println("initialized.");

		barChart.setBarGap(0);
		barChart.setLegendVisible(false);

		XYChart.Series<String, Integer> series = new Series<>(data);

		barChart.getData().add(series);
	}

	public void init(Model model) {
		this.model = model;
		model.addObserver(this);

		for (String s : model.getNames()) {
			System.out.println("write " + s);
			this.data.add(new Data<String, Integer>(s, model.getQuantity(s)));
		}
	}

	@Override
	public void update(Observable o, Object arg) {

		@SuppressWarnings("unchecked")
		HashMap.Entry<String, Integer> entry = (Entry<String, Integer>) arg;

		// this code adds the changed value if not already in data
		boolean isNew = true;
		for (XYChart.Data<String, Integer> d : data) {
			if (entry.getKey().equals(d.getXValue())) {
				d.setYValue(entry.getValue());
				isNew = false;
			}
		}

		if (isNew) {
			this.data.add(new Data<String, Integer>(entry.getKey(), entry.getValue()));
		}
	}
}
