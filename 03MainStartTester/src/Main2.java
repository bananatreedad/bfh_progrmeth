import java.io.IOException;

public class Main2 {

	public static void main(String[] args) {
		try {
			Main1.main(args);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
