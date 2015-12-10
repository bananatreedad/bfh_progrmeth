import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class LamdaTester3 {

	public static void main(String[] args) {
		Function<String, String> invert = (s) -> s.toUpperCase();

		System.out.println(invert.apply("johnny"));

		// Optional

		Optional<String> optional = Optional.of("asdf");

		if (optional.isPresent())
			System.out.println(optional.get());
		else {
			System.out.println(optional.orElse("fallback"));
		}

		optional.ifPresent((s) -> System.out.println(s.charAt(0)));
	}

}
