package ch.bananenbaum.bbfinanz.view;

import ch.bananenbaum.bbfinanz.model.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewAccountViewController {
	
	@FXML
	private TextField tefi_name;
	
	@FXML
	private Button btn_add;
	
	private Model model;
	
	private Stage stage;

	public void init(Stage stage, Model model) {
		this.model = model;
		this.stage = stage;
	}

	@FXML
	private void pressed_btn_add() {
		model.addAccount(tefi_name.getText());
		stage.close();
	}
}
