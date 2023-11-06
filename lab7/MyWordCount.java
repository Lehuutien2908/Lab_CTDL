package lab7;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		List<WordCount> res = new ArrayList<>();
		for (String w : words) {
			WordCount wc = new WordCount(w, countWord(w));
			if (!res.contains(wc)) {
				res.add(wc);
			}
		}
		return res;
	}

	public int countWord(String word) {
		int count = 0;
		for (String w : words) {
			if (w.equals(word)) {
				count++;
			}
		}
		return count;
	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> res = new HashSet<>();
		List<WordCount> list = getWordCounts();
		for (WordCount wc : list) {
			if (wc.getCount() == 1) {
				res.add(wc.getWord());
			}
		}
		return res;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		return new HashSet<>(words);
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
		Set<WordCount> res = new TreeSet<>(new Comparator<WordCount>() {

			@Override
			public int compare(WordCount w1, WordCount w2) {
				return w1.getWord().compareTo(w2.getWord());
			}
		});
		res.addAll(getWordCounts());
		return res;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public <T> Set<WordCount> exportWordCountsByOccurence() {
		Set<WordCount> res = new TreeSet<>(new Comparator<WordCount>() {

			@Override
			public int compare(WordCount w1, WordCount w2) {
				if (w1.getCount() == w2.getCount()) {
					return -(w1.getWord().compareTo(w2.getWord()));
				} else {
					return -(w1.getCount() - w2.getCount());
				}
			}

		});
		res.addAll(getWordCounts());
		return res;
	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(String pattern) {
		Set<String> res = new HashSet<>();
		Set<String> w = getDistinctWords();
		for (String wc : w) {
			if (!wc.startsWith(pattern)) {
				res.add(wc);
			}
		}
		return res;
	}
}
