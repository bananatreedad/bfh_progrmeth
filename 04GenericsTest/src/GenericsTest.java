import java.awt.Rectangle;
import java.util.ArrayList;

public class GenericsTest {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList<>();

		list.add(1);
		list.add("String");
		list.add(new Rectangle());
		
		int i = (int) list.get(0);
		System.out.println(i);
	}
}
