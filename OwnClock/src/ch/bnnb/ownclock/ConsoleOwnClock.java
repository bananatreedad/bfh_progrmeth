package ch.bnnb.ownclock;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class ConsoleOwnClock implements Observer {
	private OwnClock clock;
	
	public ConsoleOwnClock(OwnClock clock) {
		this.clock = clock;
		clock.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		try {
			Runtime.getRuntime().exec("clear");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Stopped time: " + (long) arg / 1000);
	}
}
