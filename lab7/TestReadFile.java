package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestReadFile {
	public static void main(String[] args) throws FileNotFoundException {
		// Scanner input = new Scanner(new File("data/hamlet.txt"));
		Scanner input = new Scanner(new File("data/fit.txt"));

		while (input.hasNext()) {
			String word = input.next();
			System.out.println(word);
		}
		MyWordCount myTest = new MyWordCount();
		System.out.println(myTest.getWordCounts());
		System.out.println(myTest.getUniqueWords());
		System.out.println(myTest.getDistinctWords());
		System.out.println(myTest.printWordCounts());
		System.out.println(myTest.exportWordCountsByOccurence());
		System.out.println(myTest.filterWords("L"));
	}
}