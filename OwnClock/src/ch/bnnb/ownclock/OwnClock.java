package ch.bnnb.ownclock;

import java.util.Date;
import java.util.Observable;

public class OwnClock extends Observable implements Runnable {

	private Date time;

	public OwnClock(Date startTime) {
		time = startTime;
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				long tmpTime = time.getTime() + 1000;
				time.setTime(tmpTime);

				// for debugging purposes
				// System.out.println(time.getTime());

				this.setChanged();
				this.notifyObservers(tmpTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
