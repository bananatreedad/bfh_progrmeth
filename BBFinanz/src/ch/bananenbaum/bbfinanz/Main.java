package ch.bananenbaum.bbfinanz;
import ch.bananenbaum.bbfinanz.model.Model;
import ch.bananenbaum.bbfinanz.view.AccountViewStage;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This project is a example project to build a JFX application from the button
 * up.
 * 
 * @author seed@bananatreedad.ch
 */
public class Main extends Application {


	@Override
	public void start(Stage primaryStage) throws Exception {
		Model model = new Model();
		
		new AccountViewStage(model);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
