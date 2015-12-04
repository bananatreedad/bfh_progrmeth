package application.mvc;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AnalogStopwatch extends Stage implements Observer {
	
	public final TimerTeacher timer;
	public final Canvas canvas;
	
	public AnalogStopwatch(TimerTeacher timer) {

		BorderPane pane = new BorderPane();
		pane.getStyleClass().add("background");
		
		this.timer = timer;
		timer.addObserver(this);

		this.canvas = new Canvas(240, 240);
		
		pane.setCenter(this.canvas);
		this.paint();
		
		final Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.setTitle("Analog Stopwatch");
		this.setScene(scene);
		this.setX(520);
		this.setY(200);
		this.show();
	}

	private void paint() {

		GraphicsContext g2 = this.canvas.getGraphicsContext2D();
		g2.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());

		int cx = (int) this.canvas.getWidth() / 2;
		int cy = (int) this.canvas.getHeight() / 2;

		// Draw numbers
		for (int i = 0; i < 12; i++) {
			int n = (i + 9) % 12;
			n = (n == 0 ? 12 : n);
			int w = i * 360 / 12;
			int y = cy - (int) (Math.sin(Math.toRadians(w)) * 80);
			int x = cx - (int) (Math.cos(Math.toRadians(w)) * 80);
			g2.setStroke(Color.BLACK);
			g2.fillText("" + n, x - 5, y + 5);
		}

		// Draw hour hand
		double h = ((timer.getHours() % 12) + 3 + (timer.getMinutes() / 60.0)) * 360 / 12;

		int y = cy - (int) (Math.sin(Math.toRadians(h)) * 40);
		int x = cx - (int) (Math.cos(Math.toRadians(h)) * 40);

		g2.setStroke(new Color(0.7, 0, 0, 1));
		g2.setStroke(Color.rgb(37,138,210));
		g2.setLineWidth(2f);
		g2.strokeLine(cx, cy, x, y);

		// draw minute hand
		int m = (timer.getMinutes() + 15) * 6;
		y = cy - (int) (Math.sin(Math.toRadians(m)) * 60);
		x = cx - (int) (Math.cos(Math.toRadians(m)) * 60);
//		g2.setStroke(new Color(0.7, 0.7, 0, 1));
		g2.setStroke(Color.LIGHTGREEN);
		g2.setLineWidth(2f);
		g2.strokeLine(cx, cy, x, y);

		// draw second hand
		int s = (timer.getSeconds() + 15) * 6;
		y = cy - (int) (Math.sin(Math.toRadians(s)) * 70);
		x = cx - (int) (Math.cos(Math.toRadians(s)) * 70);
//		g2.setStroke(new Color(0, 0, 0, 1));
		g2.setStroke(Color.rgb(37,138,210));
		g2.setLineWidth(1f);
		g2.strokeLine(cx, cy, x, y);
	}

	@Override
	public void update(Observable o, Object arg) {
		Platform.runLater(() -> {
			this.paint();
		});
	}
}
