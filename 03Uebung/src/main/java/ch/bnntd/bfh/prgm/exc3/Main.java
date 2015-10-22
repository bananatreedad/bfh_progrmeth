package ch.bnntd.bfh.prgm.exc3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.bfh.modulBTX8051.Aufg14.base.Person;
import ch.bnntd.bfh.prgm.filesexc.EmptyFileException;
import ch.bnntd.bfh.prgm.filesexc.PersonDataProcessor;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		try {
			File file = new File(Main.class.getResource("DataCSVmn.txt").getFile());
			logger.debug(file.getAbsolutePath());
			TreeMap<Long, Person> treeMap = PersonDataProcessor.buildMapFromFile(file);

			File file2 = new File(Main.class.getResource("DataCSVwn.txt").getFile());
			logger.debug(file2.getAbsolutePath());
			TreeMap<Long, Person> treeMap2 = PersonDataProcessor.buildMapFromFile(file2);
			

			System.out.println("Men map size: " + treeMap.size());
			System.out.println("Women map size: " + treeMap2.size());
			
			TreeMap<Long, Person> mergedMap = PersonDataProcessor.mergeTwoMaps(treeMap, treeMap2);
			System.out.println("Merged map size: " + mergedMap.size());
			

		} catch (FileNotFoundException e) {
			logger.error("File not found.");
		} catch (EmptyFileException e) {
			logger.error("File was empty.");
		}
	}
}
