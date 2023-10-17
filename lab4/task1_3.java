package lab4;

import java.util.Arrays;

public class task1_3 {
	public static void insertionSort(int[] arr) {
			for (int i = 1; i < arr.length; i++) {
				int key = arr[i];
				int index = i;
				for (int j = i - 1; j > -1; j--) {
					if(key<arr[j]) {
						arr[j+1]=arr[j];
						index--;
					}
				}
				int temp = arr[index];
				arr[index] = key;
				key = temp;
			}
			System.out.println(Arrays.toString(arr));
		
	}
	public static void main(String[] args) {
		int[] arr = { 15, 30, 25, 211, 326, 29 };
		insertionSort(arr);
	}
}
