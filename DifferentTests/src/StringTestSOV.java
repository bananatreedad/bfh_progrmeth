
public class StringTestSOV {

	public static void main(String[] args) {
		String origin = "Friday Oct 30";

		String[] split = origin.split(" ");

		String newString = split[2] + "-" + split[1] + "-2015";
		System.out.println(newString);

	}

}
