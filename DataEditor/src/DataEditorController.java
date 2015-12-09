import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DataEditorController {
	
	@FXML
	private Button addButton;
	
	@FXML 
	private TextField labelTextField;
	
	@FXML
	private TextField valueTextField;

	@FXML
	private void addButtonOnAction() {
		System.out.println("labelTextField.Text: " + labelTextField.getText());
		System.out.println("valueTextField.Text: " + valueTextField.getText());
		
		labelTextField.setText("");
		valueTextField.setText("");
	}
	
}
