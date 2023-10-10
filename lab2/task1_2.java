package lab2;

public class task1_2 {
	public static int getFibonacci(int n) {
		if (n == 1) {
			return 0;
		} else if (n == 2) {
			return 1;
		} else {
			return getFibonacci(n - 1) + getFibonacci(n - 2);
		}
	}

	public static void printFibonacci(int n) {
		for (int i = 1; i <= n; i++) {
			System.out.print(getFibonacci(i) + "\t");
		}
	}

	public static void main(String[] args) {
		int n = 10;
		System.out.println(getFibonacci(n));
		printFibonacci(n);
	}
}
