package lab4;

import java.util.Arrays;
import java.util.Random;

public class task2_2 {
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int pivotIndex = getPivot_MedianOfThree(arr, left, right);
			int pivotNewIndex = partition(arr, left, right, pivotIndex);
			quickSort(arr, left, pivotNewIndex - 1);
			quickSort(arr, pivotNewIndex + 1, right);
		}
	}

	public static int partition(int[] arr, int left, int right, int pivotIndex) {
		int pivotValue = arr[pivotIndex];
		swap(arr, pivotIndex, right);
		int i = left;
		for (int j = left; j < right; j++) {
			if (arr[j] < pivotValue) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, right);
		return i;
	}

	private static int getPivot_MedianOfThree(int[] arr, int left, int right) {
		int mid = left + (right - left) / 2;
		if (arr[left] > arr[mid]) {
			swap(arr, left, mid);
		}
		if (arr[left] > arr[right]) {
			swap(arr, left, right);
		}
		if (arr[mid] > arr[right]) {
			swap(arr, mid, right);
		}
		return mid;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// select pivot element based on the first element in the array

	private static int getPivot_First(int[] array, int left, int right) {
		return left;
	}

	// select pivot element based on the last element in the array

	private static int getPivot_Last(int[] array, int left, int right) {
		return right;
	}

	// select pivot element based on choosing a randomly element in the array

	private static int getPivot_Random(int[] array, int left, int right) {
		Random rd = new Random();
		return rd.nextInt(right - left + 1) + left;
	}

	public static void main(String[] args) {
		int[] arr = { 15, 30, 25, 211, 326, 29 };
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
