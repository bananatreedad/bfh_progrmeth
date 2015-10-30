package ch.bnntd.bfh.prgm.exc3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.bfh.modulBTX8051.Aufg14.base.Person;
import ch.bnntd.bfh.prgm.filesexc.EmptyFileException;
import ch.bnntd.bfh.prgm.filesexc.PersonDataProcessor;
import ch.bnntd.bfh.prgm.filesexc.PersonDataProcessorUtil;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws IOException {

		try {
			File file = new File(Main.class.getResource("DataCSVmn.txt").getFile());

			TreeMap<Long, Person> treeMap = PersonDataProcessor.buildMapFromFile(file);

			File file2 = new File(Main.class.getResource("DataCSVwn.txt").getFile());
			logger.debug(file2.getAbsolutePath());
			TreeMap<Long, Person> treeMap2 = PersonDataProcessor.buildMapFromFile(file2);

			System.out.println("Men map size: " + treeMap.size());
			System.out.println("Women map size: " + treeMap2.size());

			TreeMap<Long, Person> mergedMap = PersonDataProcessor.mergeTwoMaps(treeMap, treeMap2);
			System.out.println("Merged map size: " + mergedMap.size());

			TreeMap<Long, Person> reversedMergedMap = PersonDataProcessor.reverseTreeMap(mergedMap);

			PersonDataProcessorUtil.printMap(reversedMergedMap);
			// PersonDataProcessorUtil.printMapWithLamda(mergedMap);

			TreeMap<Long, Person> heinigerMap = PersonDataProcessor.searchPersons("n", "heiniger",
					mergedMap);
			System.out.println("heinigerMap: " + heinigerMap.size());

			TreeMap<Long, Person> y1992Map = PersonDataProcessor.searchPersons("y", "1992",
					mergedMap);
			System.out.println("y1992Map: " + y1992Map.size());

			TreeMap<Long, Person> annaMap = PersonDataProcessor.searchPersons("f", "Anna",
					mergedMap);
			System.out.println("annaMap: " + annaMap.size());

			TreeMap<Long, Person> maleMap = PersonDataProcessor.searchPersons("g", "m",
					mergedMap);
			System.out.println("maleMap: " + maleMap.size());
			
			File myFile = new File("test.txt");
			myFile.createNewFile();
			PersonDataProcessor.writeMapToFile(myFile, annaMap);
			
			File myKeyFile = new File("keystest.txt");
			myKeyFile.createNewFile();
			PersonDataProcessor.writeKeysToFile(myKeyFile, y1992Map.keySet());
			
			Set<Long> keySet = PersonDataProcessor.writeNotUsedKeysToSet(maleMap);
			
			File myFreeKeyFile = new File("freekeystest.txt");
			myFreeKeyFile.createNewFile();
			PersonDataProcessor.writeKeysToFile(myFreeKeyFile, keySet);

		} catch (FileNotFoundException e) {
			logger.error("File not found.");
		} catch (EmptyFileException e) {
			logger.error("File was empty.");
		}
	}
}
