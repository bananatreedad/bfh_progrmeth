package ch.bnntd.pgmmtd.mailclient;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SendingMailController {

	private Stage stage;

	private DoubleProperty progress = new SimpleDoubleProperty();

	@FXML
	private BorderPane root;

	@FXML
	private ProgressBar progressBar;

	public SendingMailController() {
	}

	public void init(Stage mainStage, boolean mailSuccess, String errorMessage) {
		this.stage = mainStage;
		stage.initStyle(StageStyle.UNDECORATED);

		progressBar.progressProperty().bind(progress);

		initAndStartSendThread(mailSuccess, errorMessage);

	}

	private void initAndStartSendThread(boolean mailSuccess, String errorMessage) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (progress.get() < 1.0 && mailSuccess) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					progress.set(progress.get() + 0.001);
				}

				Platform.runLater(() -> {

					VBox box = new VBox(10);
					box.setAlignment(Pos.CENTER);
					root.setBottom(box);


					Label label = new Label();
					label.setText(mailSuccess ? "Email sent." : "Not sent: " + errorMessage);

					Button btn_ok = new Button("OK");

					btn_ok.setOnAction(event -> stage.close());

					box.getChildren().addAll(label, btn_ok);

					stage.sizeToScene();
				});

			}
		});

		thread.start();
	}

}
