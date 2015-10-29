import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import ch.bananatreedad.jntimestopper.JNTimeStopper;

public class MapTester {

	public static void main(String[] args) {

		// TreeSet: sorted, after tree algorithm
		// HashMap: not sorted, but fast

		Map<String, String> hashMap = new HashMap<>();
		fillMap(hashMap);

		Map<String, String> treeMap = new TreeMap<>();
		fillMap(treeMap);

		Map<String, String> linkedHashMap = new LinkedHashMap<>();
		fillMap(linkedHashMap);

		System.out.println("TreeMap:");
		System.out.println(treeMap);
		printMap(treeMap);

		System.out.println();

		System.out.println("HashMap:");
		System.out.println(hashMap);
		printMap(hashMap);

		System.out.println();

		System.out.println("LinkedHashMap:");
		System.out.println(linkedHashMap);
		printMap(linkedHashMap);
		System.out.println("");
		printMapWithKey(linkedHashMap);

		Map<String, String> map = new LinkedHashMap<>();
		fillMapWithNEntries(map, 10000);

		JNTimeStopper jnt = new JNTimeStopper();
		jnt.start();
		printMap(map);
		long printmap = jnt.stop();

		jnt.start();
		printMapWithKey(map);
		System.out.println(jnt.stop());
		System.out.println(printmap);

		// add a map to another map
		TreeMap<String, String> map1 = new TreeMap<>();
		fillMap(map1);

		TreeMap<String, String> map2 = new TreeMap<>();
		fillMapDifferent(map2);

		map1.putAll(map2);
		printMap(map1);

	}

	private static void fillMapDifferent(TreeMap<String, String> map2) {
		map2.put("3000", "Phils");
		map2.put("6000", "Aight");
		map2.put("0000", "this");
		map2.put("7000", "works");
		map2.put("8000", ":D");
	}

	public static void fillMap(Map<String, String> map) {
		map.put("3000", "Phil");
		map.put("5000", "Konrad");
		map.put("4000", "Jürgen");
		map.put("2000", "Bobby");
		map.put("1000", "Ashley");
	}

	public static void fillMapWithNEntries(Map<String, String> map, int n) {
		for (int i = 0; i < n; i++) {
			map.put(Integer.toString(i * 100), "Name " + i);
		}
	}

	public static void printMap(Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	public static void printMapWithKey(Map<String, String> map) {
		for (String key : map.keySet()) {
			System.out.println(key + ": " + map.get(key) + " (Key method)");
		}
	}
}
