package lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	// <word, its occurrences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Load data from fileName into the above map (containing <word, its
	// Occurrences>)
	// using the guide given in TestReadFile.java
	public void loadData() throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));
		while (input.hasNext()) {
			String word = input.next();
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		System.out.println(map);
	}

	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() {
		return map.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key + " " + val);
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		Map<String, Integer> tree = new TreeMap<>(map);
		for (Map.Entry<String, Integer> entry : tree.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key + " " + val);
		}
	}
	public static void main(String[] args) throws FileNotFoundException{
		MyWordCountApp test = new MyWordCountApp();
		test.loadData();
		System.out.println(test.countUnique());
//		test.printWordCounts();
		test.printWordCountsAlphabet();
	}
}
