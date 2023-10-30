package lab5;

public class task1_4 {
	public static int[][] transpose(int[][] a) {
		int row = a[0].length;
		int col = a.length;

		int[][] res = new int[row][col];

		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				res[i][j] = a[j][i];
			}
		}
		return res;
	}

	public static void printMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] arr1 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		int[][] arr2 = { { 1, 3, 5 }, { 2, 4, 6 } };
		printMatrix(transpose(arr1));
		System.out.println("        ");
		printMatrix(transpose(arr2));
	}
}
