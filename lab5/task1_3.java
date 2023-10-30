package lab5;

public class task1_3 {
	public static int[][] multiply(int[][] a, int[][] b) {
		int[][] res = new int[a.length][b[0].length];
//		for (int i = 0; i < res.length; i++) {
//			for (int j = 0; j < res[i].length; j++) {
//				res[i][j] = sum(a, b, i, j);
//			}
//		}
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				for (int k = 0; k < a[0].length; k++) {
					res[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return res;
	}

//	public static int sum(int[][] a, int[][] b, int row, int col) {
//		int digit = b.length;
//		int res = 0;
//		while (digit > 0) {
//			res += a[row][digit - 1] * b[digit - 1][col];
//			digit--;
//		}
//		return res;
//	}

	public static void printMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4 }, { 4, 3, 2, 1 } };
		int[][] b = { { 1, 2, 3 }, { 3, 2, 1 }, { 2, 1, 3 }, { 2, 3, 1 } };
		printMatrix(multiply(a, b));
	}
}
