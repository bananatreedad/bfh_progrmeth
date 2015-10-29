import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class ForeachTest {

	public static void main(String[] args) {

		Collection<String> littleTest = new ArrayList<>();
		littleTest.add("bla");
		littleTest.add("test");
		littleTest.add("test");
		littleTest.add("wtf");

		System.out.println(littleTest);

		littleTest.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				if (t == "test")
					littleTest.remove(t);

			}
		});
		
		for(String s : littleTest) {
			if(s.equals("test")) {
				littleTest.remove(s);
			}
		}
		
		System.out.println(littleTest);
		
		Iterator<String> it = littleTest.iterator();
		while(it.hasNext()) {
			String next = it.next();
			
			if(next.equals("test")) {
				it.remove();
			}
		}
		
		System.out.println(littleTest);
	}
}
