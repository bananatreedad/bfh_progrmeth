import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LamdaTester {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia",
				"peter", "anna", "mike", "xenia", "peter", "anna", "mike",
				"xenia", "peter", "anna", "mike", "xenia", "peter", "anna",
				"mike", "xenia");

		System.out.println(names);
		// sortNormal(names);
		lambdaSort(names);
		System.out.println(names);

	}

	public static void lambdaSort(List<String> names) {
		names.sort((a, b) -> a.compareTo(b));
	}

	public static void sortNormal(List<String> names) {
		long beginning = System.currentTimeMillis();

		names.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// System.out.println("Comparing " + o1 + " to " + o2 + ".
				// Result: " + o1.compareTo(o2));
				return o1.compareTo(o2);
			}
		});

		long ending = System.currentTimeMillis();
		System.out
				.println("Normal sorting took " + (ending - beginning) + "ms.");
	}
}
