import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class CollectionsTester {
	public static void main(String[] args) {

		Collection<String> names = null;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a list. (AL=ArrayList, LL=LinkedList, HS=HashSet, TS=TreeSet)");
		String param = scanner.next();
		System.out.println("Parameter: " + param);

		if (param.equals("AL"))
			names = new ArrayList<>();
		else if (param.equals("LL"))
			names = new LinkedList<>();
		else if (param.equals("HS"))
			names = new HashSet<>();
		else if (param.equals("TS"))
			names = new TreeSet<>();
		else {
			System.out.println("No valid entry. Terminate program.");
			System.exit(0);
		}

		fill(names);
		System.out.println("Anzahl Elemente: " + names.size());
		names.remove("Emily");
		System.out.println("Cindy vorhanden? " + names.contains("Cindy"));
		manipulateData(names);
		manipulateData(names);
		
		scanner.close();
	}

	private static void fill(Collection<String> c) {
		c.add("Cindy");
		c.add("Emily");
		c.add("Peter");
		c.add("Bob");
	}

	private static void manipulateData(Collection<String> c) {
		Iterator<String> i = c.iterator();
		int element = 1;
		while (i.hasNext()) {
			String e = i.next();
			if (e.equals("Peter"))
				//Advantage over for-loop; remove is possible
				i.remove();
			else
				System.out.println("Element " + element + ": " + e);
			element++;
		}
	}
}