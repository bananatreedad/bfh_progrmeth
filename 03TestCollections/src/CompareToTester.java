import java.util.ArrayList;
import java.util.TreeSet;
import java.util.function.Function;

import ch.bananatreedad.jntimestopper.JNTimeStopper;

public class CompareToTester {

	public static void main(String[] args) {

		TreeSet<Lion> lionSet = new TreeSet<>();

		// lionSet.add(new Lion("test", 123));
		// would crash with a runtime exception - doesn't make sense?
		// reason:
		// http://stackoverflow.com/questions/13890542/creating-a-treeset-with-a-non-comparable-class-why-a-run-time-exception-rather

		System.out.println(lionSet);
		Function<Integer, ArrayList<Lion>> generateNLions = (n) -> {

			ArrayList<Lion> lions = new ArrayList<Lion>();

			for (int i = 0; i < n; i++) {
				Lion lion = new Lion("Lion " + n, n);
				lions.add(lion);
			}

			return lions;
		};

		JNTimeStopper jnt = new JNTimeStopper();
		jnt.start();
		ArrayList<Lion> lionList = generateNLions.apply(10000);
		System.out.println(jnt.stop());

		System.out.println(lionList);
		lionList.sort((lion1, lion2) -> {
			return lion1.getName().compareTo(lion2.getName());
		});
	}
}
