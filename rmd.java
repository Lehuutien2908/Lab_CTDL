package bai1;

import java.util.Arrays;

public class rmd {
	public static int[] removeDuplicates(int[] arr) {
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (arr[i] == arr[j]) {
					for (int k = j; k < length - 1; k++) {
						arr[k] = arr[k + 1];
					}
					length--;
					j--;
				}
			}
		}
		int[] res = new int[length];
		for (int i = 0; i < res.length; i++) {
			res[i]=arr[i];
		}

		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 1, 3, 7, 9, 5 };
		System.out.println(Arrays.toString(removeDuplicates(arr)));
	}
}
