package lab4;

import java.util.Arrays;

public class task2_1 {
	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}
	public static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	public static void merge(int[] arr, int left, int mid, int right) {
		int nL = mid - left + 1;
		int nR = right - mid;
		int[] arrL = new int[nL];
		int[] arrR = new int[nR];
		for (int i = 0; i < nL; ++i) {
			arrL[i] = arr[left + i];
		}
		for (int i = 0; i < nR; ++i) {
			arrR[i] = arr[mid + 1 + i];
		}
		int i = 0;
		int j = 0;
		int k = left;

		while (i < nL && j < nR) {
			if (arrL[i] <= arrR[j]) {
				arr[k] = arrL[i];
				i++;
			} else {
				arr[k] = arrR[j];
				j++;
			}
			k++;
		}
		while (i < nL) {
			arr[k] = arrL[i];
			i++;
			k++;
		}
		while (j < nR) {
			arr[k] = arrR[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 15, 30, 25, 211, 326, 29 };
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
