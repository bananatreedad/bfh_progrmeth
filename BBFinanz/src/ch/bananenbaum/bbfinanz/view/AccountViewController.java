package ch.bananenbaum.bbfinanz.view;

import java.util.Observable;
import java.util.Observer;

import ch.bananenbaum.bbfinanz.model.Account;
import ch.bananenbaum.bbfinanz.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;

public class AccountViewController implements Observer {
	
	@FXML
	private Button btn_delete;
	
	@FXML
	private Button btn_add;
	
	@FXML
	private MenuItem mit_closeApp;
	
	@FXML
	private ListView<Account> livi_accounts;

	private ObservableList<Account> accountList = FXCollections.observableArrayList();
	
	private Model model;
	
	@FXML
	private void initialize() {
		this.livi_accounts.setItems(accountList);
	}
	
	public void init(Model model) {
		this.model = model;
		model.addObserver(this);
		
		this.accountList.addAll(model.getAccountList());
	}
	
	@FXML
	private void pressed_btn_add() {
		model.addAccount("test");
	}
	
	@FXML
	private void pressed_btn_delete() {
	}
	
	@FXML
	private void pressed_mit_closeApp() {
		System.exit(0);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.accountList.clear();
		this.accountList.addAll(model.getAccountList());
	}
}
