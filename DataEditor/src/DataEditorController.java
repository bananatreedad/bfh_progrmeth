import java.util.Observable;
import java.util.Observer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DataEditorController implements Observer {
	
	@FXML
	private Button addButton;
	
	@FXML 
	private TextField labelTextField;
	
	@FXML
	private TextField valueTextField;

	@FXML
	private void initialize() {
		System.out.println();
	}

	public void init(Model model) {
		
	}
	
	@FXML
	private void addButtonOnAction() {
		System.out.println("labelTextField.Text: " + labelTextField.getText());
		System.out.println("valueTextField.Text: " + valueTextField.getText());
		
		labelTextField.setText("");
		valueTextField.setText("");
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
