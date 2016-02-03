package ch.bnnb.ownclock;

import java.util.Date;
import java.util.Observable;

public class OwnClock extends Observable implements Runnable {

	private Date time;
	private Thread thread;

	public OwnClock(Date startTime) {
		time = startTime;
		thread = null;
	}

	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.setDaemon(true);
			thread.setPriority(Thread.MAX_PRIORITY);
			thread.start();

			this.setChanged();
			this.notifyObservers(time.getTime());
		}
	}

	public void stop() {
		if (thread != null) {
			thread = null;
		}

		this.setChanged();
		this.notifyObservers(time.getTime());
	}

	@Override
	public void run() {
		while (thread != null) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (thread != null) {
				long tmpTime = time.getTime() + 100;
				time.setTime(tmpTime);

				// for debugging purposes
				// System.out.println(time.getTime());

				this.setChanged();
				this.notifyObservers(tmpTime);
			}
		}
	}
}
