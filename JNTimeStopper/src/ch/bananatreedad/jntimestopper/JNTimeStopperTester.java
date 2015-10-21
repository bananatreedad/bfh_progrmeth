package ch.bananatreedad.jntimestopper;

public class JNTimeStopperTester {

	public static void main(String[] args) {
		JNTimeStopper jnt = new JNTimeStopper();
		
		jnt.start();
		for (int i = 0; i < 10000; i++) {
			System.out.println("test");
		}
		long delta = jnt.stop();
		System.out.println(delta);
		System.out.println(1);
		
		jnt.start();
		for (int i = 0; i < 10000; i++) {
			System.out.println("test");
		}
		System.out.println(jnt.stop());
		jnt.stop();
		System.out.println(2);

	}

}
