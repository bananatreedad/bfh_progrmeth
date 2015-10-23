package ch.bananatreedad.jntimestopper;

/**
 * Makes time stopping in Java a bit easier.
 * 
 * @author jnt
 */
public class JNTimeStopper {

	private long startTime = 0;
	private long endTime = 0;

	public JNTimeStopper(){}

	public void start() {
		if (startTime == 0) {
			startTime = System.currentTimeMillis();
		} else {
			throw new RuntimeException("Already running!");
		}
	}

	/**
	 * Stops the {@link JNTimeStopper} and returns the delta in ms.
	 * 
	 * @return
	 */
	public long stop() {
		if (startTime > 0) {
			endTime = System.currentTimeMillis();
			long delta = endTime - startTime;

			startTime = 0;
			endTime = 0;

			return delta;
		} else {
			throw new RuntimeException("Not started yet.");
		}
	}
}
