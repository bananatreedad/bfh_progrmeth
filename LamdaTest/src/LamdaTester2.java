import java.util.function.Function;

public class LamdaTester2 {

	public static void main(String[] args) {
		PasswordEncoder encoder = (string) -> string.toUpperCase();
		System.out.println(encoder.encode("waschloos!?"));

		Function<String, String> func = (x) -> { 
			return x.toUpperCase(); 
		};
		System.out.println(func.apply("Johhny."));
		
		Function<String, Integer> converter = Integer::valueOf;
		System.out.println(converter.apply("123"));
	}
}
