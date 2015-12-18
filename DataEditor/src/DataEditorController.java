import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

public class DataEditorController implements Observer {

	@FXML
	private Button addButton;

	@FXML
	private TextField labelTextField;

	@FXML
	private TextField valueTextField;

	@FXML
	private TableView<Data> table;

	@FXML
	private TableColumn<Data, String> nameCol;
	
	@FXML
	private TableColumn<Data, Integer> quantCol;

	private ObservableList<Data> data;

	private Model model;

	@FXML
	private void initialize() {
		//to right after GUI is up
		this.data = FXCollections.observableArrayList();
		this.table.setEditable(true);
		table.setItems(this.data);
	}

	public void init(Model model) {
		this.model = model;

		//we'd like to get notificated if the model changes
		model.addObserver(this);

		//adds the data that are already in the model to the gui data
		for (String name : this.model.getNames()) {
			Data d = new Data(name, this.model.getQuantity(name));
			this.data.add(d);
		}
		
		//bind the properties out of data to the certain columns 
		//(the cell factory is responsible for building the cell)
		nameCol.setCellValueFactory(d -> d.getValue().nameProperty());

		//asObject is important! - http://code.makery.ch/library/javafx-8-tutorial/part2/
		quantCol.setCellValueFactory(d -> d.getValue().quantityProperty().asObject());

		//make cell editable and insert a String to IntegerConverter
		quantCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

		quantCol.setOnEditCommit((CellEditEvent<Data, Integer> t) -> {
			t.getRowValue().setQuantity(t.getNewValue());
			//TODO do I have to go through all my elements now?
			
			model.setQuantity(t.getRowValue().getName(), t.getRowValue().getQuantity());
			
			for(Data d : data) {
				System.out.println(d.name + ": " + d.getQuantity());
			}
		});
	}

	@FXML
	private void addButtonOnAction() {
		//THIS IS THE 'REAL' CONTROLLER ATM 
		//adds something to the model
		model.setQuantity(labelTextField.getText(), Integer.valueOf(valueTextField.getText()));

		labelTextField.setText("");
		valueTextField.setText("");
	}

	@Override
	public void update(Observable o, Object arg) {

		//getting an Entry from the caller (Model which we are observing)
		@SuppressWarnings("unchecked")
		HashMap.Entry<String, Integer> entry = (Entry<String, Integer>) arg;

		
		//the following code adds the new entry ONLY if the key does not exist already.
		//if the key is already set - it sets the value for it new.
		boolean isNew = true;

		for (Data d : this.data) {
			if (d.getName().equals(entry.getKey())) {
				d.setQuantity(entry.getValue());

				isNew = false;
				break;
			}
		}
		if (isNew) {
			this.data.add(new Data(entry.getKey(), entry.getValue()));
		}

	}

	//this object contains the data which are supposed to be displayed inside the table
	//a static inner class has no access on the attributes on the parental class like a normal class
	//the keyword static has an other meaning in this case!
	private static class Data {
		private final StringProperty name;
		private final IntegerProperty quantity;

		public Data(String name, Integer quantity) {
			this.name = new SimpleStringProperty(name);
			this.quantity = new SimpleIntegerProperty(quantity);
		}

		public String getName() {
			return this.name.get();
		}

		public StringProperty nameProperty() {
			return this.name;
		}

		//just not used atm and I dont like them warnings
		@SuppressWarnings("unused")
		public Integer getQuantity() {
			return this.quantity.get();
		}

		public void setQuantity(int q) {
			this.quantity.set(q);
		}

		public IntegerProperty quantityProperty() {
			return this.quantity;
		}
	}
}
