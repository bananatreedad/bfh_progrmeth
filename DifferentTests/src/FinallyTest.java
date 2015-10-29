import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FinallyTest {

	public static void main(String[] args) {

	}

	// conclusion: finally gets always called, except when:
	//
	// The thread running the try-catch-finally block is killed or interrupted
	// You use System.exit(0);
	// The underlying VM is destroyed in some other way
	// The underlying hardware is unusable in some way
	// @see:
	// http://stackoverflow.com/questions/4264874/does-a-finally-block-run-even-if-you-throw-a-new-exception

	public double[] readFile(String fileName) throws IOException {
		File inFile = new File(fileName);

		Scanner in = null;
		try {
			in = new Scanner(inFile);
			readData();
			return new double[0];
		} catch (IOException e) {
			throw new IOException();
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

	public void readData() throws IOException {

	}

}
