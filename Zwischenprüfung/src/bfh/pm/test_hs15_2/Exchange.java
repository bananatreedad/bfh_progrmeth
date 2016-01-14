package bfh.pm.test_hs15_2;

import java.util.Observable;

/**
 * The exchange model. Provides the EUR/CHF rate and notifies about rate changes
 * (pull notification, no data is pushed by the observable).
 *
 */
public class Exchange extends Observable implements Runnable {

	private Thread thread;
	private double rate;

	/**
	 * Constructor. Creates a new exchange model for the EUR/CHF rate.
	 */
	public Exchange() {
		this.rate = 1.0781;
		this.thread = new Thread(this);
		this.thread.setDaemon(true);
		this.thread.start();
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Gets the actual EUR/CHF rate.
	 * 
	 * @return The rate as double.
	 */
	public double getRate() {
		return Math.round(this.rate * 10000) / 10000.0;
	}

	@Override
	public final void run() {
		while (this.thread != null) {
			try {
				Thread.sleep((int) (Math.random() * 1000 + 500));
			} catch (InterruptedException e) {
				// do nothing
			}
			if (this.thread != null) {
				this.rate += (Math.random() - 0.5) / 500;
				this.setChanged();
				this.notifyObservers();
			}
		}
	}
}
