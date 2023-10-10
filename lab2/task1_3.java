package lab2;

import java.util.Arrays;

public class task1_3 {
	public static void printPascalTriangle(int row) {
		for (int i = 1; i <= row; i++) {
			System.out.println(Arrays.toString(getPascalTriangle(i)));
		}
	}

	public static int[] getPascalTriangle(int n) {
		if (n == 1) {
			return new int[] { 1 };
		} else {
			int[] preRow2 = getPascalTriangle(n - 1);
			return generateNextRow(preRow2);
		}
	}

	public static int[] generateNextRow(int[] prevRow) {
		int[] res = new int[prevRow.length + 1];
		res[0] = 1;
		res[prevRow.length] = 1;
		for (int i = 1; i < res.length - 1; i++) {
			res[i] = prevRow[i - 1] + prevRow[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 3, 1 };
		int n = 5;
		System.out.println(Arrays.toString(generateNextRow(arr)));
		System.out.println(Arrays.toString(getPascalTriangle(n)));
		printPascalTriangle(n);

	}
}
