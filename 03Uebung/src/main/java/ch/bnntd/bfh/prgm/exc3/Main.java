package ch.bnntd.bfh.prgm.exc3;

import java.io.File;
import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.bnntd.bfh.pgrm.filesexc.EmptyFileException;
import ch.bnntd.bfh.pgrm.filesexc.PersonDataProcessor;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		try {
			File file = new File(Main.class.getResource("DataCSVmn.txt").getFile());

			logger.debug(file.getAbsolutePath());

			PersonDataProcessor.buildMapFromFile(file);
		} catch (FileNotFoundException e) {
			logger.error("File not found.");
		} catch (EmptyFileException e) {
			logger.error("File was empty.");
		}

	}
}
