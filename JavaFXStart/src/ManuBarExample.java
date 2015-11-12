import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ManuBarExample extends Application {

	@Override
	public void start(Stage primaryStage) {
		MenuBar menuBar = new MenuBar();
//		menuBar.setUseSystemMenuBar(true);
		
		Menu itemPic = new Menu("pics");

		ImageView raedliImage = new ImageView(new Image("raedli.png", 30, 30, true, true));
		itemPic.getItems().add(new MenuItem("raedli", raedliImage));

		ImageView starImage = new ImageView(new Image("star.png", 30, 30, true, true));
		itemPic.getItems().add(new MenuItem("star", starImage));

		menuBar.getMenus().add(itemPic);
		
		Menu item = new Menu("checkable");
		item.getItems().add(new CheckMenuItem("one"));
		item.getItems().add(new CheckMenuItem("two"));
		item.getItems().add(new CheckMenuItem("three"));
		menuBar.getMenus().add(item);

		Menu item2 = new Menu("selectable");
		ToggleGroup group = new ToggleGroup();
		RadioMenuItem itemOne = new RadioMenuItem("one");
		itemOne.setToggleGroup(group);
		RadioMenuItem itemTwo = new RadioMenuItem("two");
		itemTwo.setSelected(true);
		itemTwo.setToggleGroup(group);
		RadioMenuItem itemThree = new RadioMenuItem("three");
		itemThree.setToggleGroup(group);

		item2.getItems().add(itemOne);
		item2.getItems().add(itemTwo);
		item2.getItems().add(itemThree);

		menuBar.getMenus().add(item2);
		
		primaryStage.setScene(new Scene(menuBar, 200, 200));
		primaryStage.setTitle("JavaFX Example");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
