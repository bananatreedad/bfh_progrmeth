package application.mvc;

public class Controller {
	
	private final TimerTeacher timer;

	public Controller(TimerTeacher timer) {
		this.timer = timer;
	}
	
	public void start() {
		timer.start();
		System.out.println("Started.");
	}
	
	public void stop() {
		timer.stop();
		System.out.println("Stopped.");
	}
	
	public void reset() {
		timer.reset();
		System.out.println("Resetted.");
	}

}
