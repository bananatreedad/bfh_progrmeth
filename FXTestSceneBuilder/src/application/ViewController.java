package application;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ViewController {

	@FXML
	private Text message;
	
	@FXML
	private void handleActionEvent() {
		System.out.println("Eeeevent!");
	}
}
