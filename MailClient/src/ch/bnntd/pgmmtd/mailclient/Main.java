package ch.bnntd.pgmmtd.mailclient;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		new MailClientStage();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
