import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

public class PieChartController implements Observer {

	Model model = null;

	// chart model for view
	private ObservableList<PieChart.Data> pieChartData;

	@FXML
	private PieChart pieChart;

	@FXML
	public void initialize() {
		this.pieChartData = FXCollections.observableArrayList();
		this.pieChart.setData(this.pieChartData);
		
		pieChart.setLegendVisible(false);
	}

	public void init(Model model) {
		this.model = model;
		model.addObserver(this);
		
		//add data that are already in model in view data
		for (String name : this.model.getNames()) {
			this.pieChartData.add(new PieChart.Data(name, model.getQuantity(name)));
		}
	}

	@Override
	public void update(Observable o, Object arg) {

		@SuppressWarnings("unchecked")
		HashMap.Entry<String, Integer> entry = (Entry<String, Integer>) arg;

		//this code adds the changed value if not already in data
		boolean isNew = true;
		for(PieChart.Data d : pieChartData) {
			if(entry.getKey().equals(d.getName())) {
				d.setPieValue(entry.getValue());
				isNew = false;
			}
		}
		
		if(isNew) {
			this.pieChartData.add(new PieChart.Data(entry.getKey(), entry.getValue()));
		}
	}
}
