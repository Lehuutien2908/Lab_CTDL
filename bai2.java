package lab1;

public class bai2 {
//	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
//			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	public char[] ALPHABET = new char[26];
	private int n;

	public bai2(int shiftSteps) {
		this.n = shiftSteps;
		createALPHABET();
	}

	private void createALPHABET() {
		for (int i = 0; i < ALPHABET.length; i++) {
			ALPHABET[i] = (char) ('A' + i);
		}
	}

	public char encryptChar(char c) {
		char res = ' ';
		for (int i = 0; i < ALPHABET.length; i++) {
			if (c == ALPHABET[i]) {
				res = ALPHABET[(i + n) % 26];
			}
		}
		return res;
	}

	public String encrypt(String input) {
		String res = "";
		for (int i = 0; i < input.length(); i++) {
			res += encryptChar(input.charAt(i));
		}
		return res;
	}

	public char decryptChar(char c) {
		char res = ' ';
		for (int i = 0; i < ALPHABET.length; i++) {
			if (c == ALPHABET[i]) {
				res = ALPHABET[(i - n + 26) % 26];
			}
		}
		return res;
	}

	public String decrypt(String input) {
		String res = "";
		for (int i = 0; i < input.length(); i++) {
			res += decryptChar(input.charAt(i));
		}
		return res;
	}

	public static void main(String[] args) {
		int n = 3;
		String s = "HELLO WORLD AZ";
		bai2 b = new bai2(n);
		System.out.println(b.encryptChar('K'));
		System.out.println(b.encrypt(s));
		System.out.println(b.decryptChar('K'));
		System.out.println(b.decrypt(s));
	}
}
