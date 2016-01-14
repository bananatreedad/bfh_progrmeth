import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ViewController {
	
	@FXML
	Button btn_new;
	
	
	@FXML
	private void pressed_btn_new() throws IOException {
		System.out.println("Test!");
		new ViewStage();
	}
}
