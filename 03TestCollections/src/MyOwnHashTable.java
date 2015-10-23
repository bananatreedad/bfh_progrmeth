
public class MyOwnHashTable {

	public static void main(String[] args) {
		final int CAPACITY = 11; // Defines the size of the hash table.

		String[] strings = { "Java", "Pascal", "Fortran", "Cobol", "C", "Basic", "Simula", "Algol",
				"Logo" };

		for (String s : strings) {
			System.out.println('"' + s + '"' + " | " + "hash code: " + s.hashCode()
					+ " | array index: " + Math.abs(s.hashCode() % CAPACITY));
		}
	}
}
