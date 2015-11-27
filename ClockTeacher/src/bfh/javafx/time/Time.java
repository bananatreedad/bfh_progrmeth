package bfh.javafx.time;

import java.time.LocalTime;
import java.util.Observable;

public class Time extends Observable implements Runnable {

	private int time;
	private boolean forward;

	public Time() {
		this.reset();

		// Start clock
		final Thread thread = new Thread(this);
		thread.setDaemon(true);
		thread.start();
	}

	public void runForward() {
		this.forward = true;
		this.setChanged();
		this.notifyObservers();
	}

	public void runBackward() {
		this.forward = false;
		this.setChanged();
		this.notifyObservers();
	}

	public void reset() {
		this.forward = true;
		
		final LocalTime now = LocalTime.now();
		this.time = (now.getHour() * 60 + now.getMinute()) * 60 + now.getSecond();
		
		this.setChanged();
		this.notifyObservers();
	}

	public boolean isForward() {
		return this.forward;
	}

	public int getTime() {
		return this.time;
	}

	public int getHours() {
		return this.time / 3600;
	}

	public int getMinutes() {
		return (this.time / 60) % 60;
	}

	public int getSeconds() {
		return this.time % 60;
	}

	private void changeTime() {
		this.time += this.forward ? 1 : -1;
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				this.changeTime();
			} catch (InterruptedException e) {
			}
		}
	}
}
