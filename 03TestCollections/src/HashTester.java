import java.util.HashSet;
import java.util.Set;

public class HashTester {

	public static void main(String[] args) {

		// Hash of a normal String class
		String string = "Hello!";
		String string2 = "Hello!";

		System.out.println(string.hashCode());
		System.out.println(string2.hashCode());

		System.out.println("\nIs string == string2?");
		System.out.println(string.equals(string2));

		Lion lion1 = new Lion("Lewis", 12);
		System.out.println("hash lion1: " + lion1.hashCode());
		Lion lion2 = new Lion("Conul", 20);
		System.out.println("hash lion2: " + lion2.hashCode());
		Lion lion3 = new Lion("Lewis", 12);
		System.out.println("hash lion3: " + lion3.hashCode());

		System.out.println("\nlion1 equals lion2?");
		System.out.println(lion1.equals(lion2));
		System.out.println("lion1 equals lion3?");
		System.out.println(lion1.equals(lion3));

		Set<Lion> set = new HashSet<>();
		set.add(lion1);
		set.add(lion2);
		boolean test = set.add(lion3);

		// was already there or not?
		System.out.println(test);

	}
}
