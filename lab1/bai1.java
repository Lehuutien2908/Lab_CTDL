package lab1;

import java.util.Arrays;

public class bai1 {
	private int[] arr;

	public bai1(int[] arr) {
		this.arr = arr;
	}

	public int[] mirror() {
		int[] res = new int[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
			res[arr.length * 2 - i - 1] = arr[i];
		}

		return res;
	}

	public int[] removeDuplicates() {
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
			res[i] = arr[i];
		}

		return res;
	}

	public int[] getMissingValues() {
		int[] missingValues = new int[arr.length];
		int n = missingValues.length;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] != arr[i] + 1) {
				missingValues[i + 1] = (arr[i] + 1);
			}
		}
		for (int i = 0; i < n; i++) {
			if (missingValues[i] == 0) {
				for (int j = i; j < n - 1; j++) {
					missingValues[j] = missingValues[j + 1];
				}
				i--;
				n--;
			}
		}
		int[] res = Arrays.copyOf(missingValues, n);
		return res;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 1, 3, 5, 7, 1, 3, 9 };
		int[] arr3 = { 11, 12, 13, 14, 16, 17, 19, 20, 22 };
		bai1 b1 = new bai1(arr1);
		bai1 b2 = new bai1(arr2);
		bai1 b3 = new bai1(arr3);
		System.out.println(Arrays.toString(b1.mirror()));
		System.out.println(Arrays.toString(b2.removeDuplicates()));
		System.out.println(Arrays.toString(b3.getMissingValues()));
	}
}
