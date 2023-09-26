package bai1;

public class maHoa {
	public static final char encryptChar(char c, int n) {
//		char[]	ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F',
//			'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
//			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		char[] ALPHABET = new char[26];
		char res = ' ';
		for (int i = 0; i < ALPHABET.length; i++) {
			ALPHABET[i] = (char) ('A' + i);
		}
		for (int i = 0; i < ALPHABET.length; i++) {
			if (ALPHABET[i] == c) {
				res = ALPHABET[(i + n) % 26];
			}
		}
		return res;
	}

	public static char decryptChar(char c, int n) {
		char[] ALPHABET = new char[26];
		char res = ' ';
		for (int i = 0; i < ALPHABET.length; i++) {
			ALPHABET[i] = (char) ('A' + i);
		}
		for (int i = 0; i < ALPHABET.length; i++) {
			if (ALPHABET[i] == c) {
				res = ALPHABET[(i - n) % 26];
			}
		}

		return res;
	}

	public static String encryptString(String c, int n) {
		char k = ' ';
		char[] ALPHABET = new char[26];
		char[] alphabet = new char[26];
		char[] number = new char[10];
		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = (char) ('a' + i);
			ALPHABET[i] = (char) ('A' + i);
		}
		for (int i = 0; i < number.length; i++) {
			number[i] = (char) ('0' + i);
		}
		String res = "";
		for (int i = 0; i < c.length(); i++) {
			k = c.charAt(i);
			if (k >= 'A' && k <= 'Z') {
				for (int j = 0; j < ALPHABET.length; j++) {
					if (ALPHABET[j] == k) {
						res += ALPHABET[(j + n) % 26];
					}
				}
			} else if (k >= 'a' && k <= 'z') {
				for (int j = 0; j < alphabet.length; j++) {
					if (alphabet[j] == k) {
						res += alphabet[(j + n) % 26];
					}
				}
			} else if (k == ' ') {
				res += " ";
			}
			for (int j = 0; j < number.length; j++) {
				if (number[j] == k) {
					res += number[(j + n) % 10];
				}
			}
		}
		return res;
	}

	public static String dencryptString(String c, int n) {
		char k = ' ';
		char[] ALPHABET = new char[26];
		char[] alphabet = new char[26];
		char[] number   = new char[10];
		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = (char) ('a' + i);
			ALPHABET[i] = (char) ('A' + i);
		}
		for (int i = 0; i < number.length; i++) {
			number[i] = (char) ('0' + i);
		}
		String res = "";
		for (int i = 0; i < c.length(); i++) {
			k = c.charAt(i);
			if (k >= 'A' && k <= 'Z') {
				for (int j = 0; j < ALPHABET.length; j++) {
					if (ALPHABET[j] == k) {
						res += ALPHABET[(j - n) % 26];
					}
				}
			} else if (k >= 'a' && k <= 'z') {
				for (int j = 0; j < alphabet.length; j++) {
					if (alphabet[j] == k) {
						res += alphabet[(j - n) % 26];
					}
				}
			} else if (k == ' ') {
				res += " ";
			}
			for (int j = 0; j < number.length; j++) {
				if (number[j] == k) {
					res += number[(j - n) % 10];
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		char c = 'K';
		String s = "Tien ngu 123";
		System.out.println(encryptChar(c, 4));
		System.out.println(decryptChar(encryptChar(c, 4), 4));
		System.out.println(encryptString(s, 4));
		System.out.println(dencryptString(encryptString(s, 4), 4));

	}
}