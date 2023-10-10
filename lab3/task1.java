package lab3;

import java.util.Arrays;

public class task1 {
	private int[] arr;

	public task1(int[] arr) {
		this.arr = arr;
	}

	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}

	private int recursiveLinearSearch(int target, int index) {
		if (index >= arr.length) {
			return -1;
		} else if (arr[index] == target) {
			return index;
		} else {
			return recursiveLinearSearch(target, index + 1);
		}
	}

	public int recursiveLinearSearch(int target) {
		return recursiveLinearSearch(target, 0);
	}

	public int iterativeBinarySearch(int target) {
		int res = 0;
		int mid = (arr.length - 1) / 2;
		Arrays.sort(arr);
		if (target == arr[mid]) {
			return res = mid;
		} else if (target > arr[mid]) {
			for (int i = mid + 1; i < arr.length; i++) {
				if (target == arr[i]) {
					return res = i;
				} else {
					res = -1;
				}
			}
		} else {
			for (int i = 0; i < mid; i++) {
				if (target == arr[i]) {
					return res = i;
				} else {
					res = -1;
				}
			}
		}
		return res;
	}

	private int recursiveBinarySearch(int target, int left, int right) {
		int mid = (left + right) / 2;
		if (arr[mid] == target) {
			return mid;
		} else if (target > arr[mid]) {
			return recursiveBinarySearch(target, mid + 1, right);
		} else if (target < arr[mid]) {
			return recursiveBinarySearch(target, left, mid - 1);
		} else {
			return -1;
		}
	}

	public int recursiveBinarySearch(int target) {
		return recursiveBinarySearch(target, 0, arr.length - 1);
	}

	public static void main(String[] args) {
		int[] arr1 = { 12, 10, 9, 45, 2, 10, 10, 45 };
		int[] arr2 = { 12, 10, 9, 45, 2, 7, 1, 46 };
		task1 t1 = new task1(arr1);
		task1 t2 = new task1(arr1);
		task1 t3 = new task1(arr2);
		task1 t4 = new task1(arr2);
		System.out.println(t1.iterativeLinearSearch(45));
		System.out.println(t2.recursiveLinearSearch(45));
		System.out.println(t3.iterativeBinarySearch(2));
		System.out.println(t4.recursiveBinarySearch(2));
	}
}
