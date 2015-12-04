package application.mvc;

public class Controller {
	
	private final TimerTeacher timer;

	public Controller(TimerTeacher timer) {
		this.timer = timer;
	}
	
	public void start() {
		System.out.println("Starting...");
		timer.start();
		System.out.println("Started.");
	}
	
	public void stop() {
		System.out.println("Stopping...");
		timer.stop();
		System.out.println("Stopped.");
	}
	
	public void reset() {
		System.out.println("Resetting...");
		timer.reset();
		System.out.println("Resetted.");
	}

}
