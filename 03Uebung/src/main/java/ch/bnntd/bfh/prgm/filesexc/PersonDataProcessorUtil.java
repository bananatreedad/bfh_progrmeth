package ch.bnntd.bfh.prgm.filesexc;

import java.util.Map;

import ch.bananatreedad.jntimestopper.JNTimeStopper;
import ch.bfh.modulBTX8051.Aufg14.base.Person;

/**
 * This class provies a few util functions to manage the data that you can get
 * out of {@link PersonDataProcessor}.
 * 
 * @author seed@bananatreedad.ch
 *
 */
public class PersonDataProcessorUtil {

	public static void printMapWithLamda(Map<Long, Person> personMap) {
		JNTimeStopper jnt = new JNTimeStopper();
		jnt.start();
		personMap.forEach((id, person) -> System.out.println("(L) Key: " + id + " | Value: " + person));
		System.out.println("Printing map with lamda exp. took : " + jnt.stop());
	}

	public static void printMap(Map<Long, Person> personMap) {
		JNTimeStopper jnt = new JNTimeStopper();
		jnt.start();
		for (Map.Entry<Long, Person> entry : personMap.entrySet()) {
			System.out.println("(L) Key: " + entry.getKey() + " | Value: " + entry.getValue());
		}
		System.out.println("Printing map took : " + jnt.stop());
	}
}
