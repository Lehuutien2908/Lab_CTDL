package lab2;

public class task1_4 {
	public static void towerOfHaNoi(int disk, char source, char dest, char spare) {
		if (disk > 0) {
			towerOfHaNoi(disk - 1, source, spare, dest);
			System.out.println("Move " + disk + " from " + source + " to " + dest);
			towerOfHaNoi(disk - 1, dest, spare, source);
		}
	}

	public static void main(String[] args) {
		int disk = 3;
		char source = 'A';
		char dest = 'B';
		char spare = 'C';
		towerOfHaNoi(disk, source, dest, spare);
	}
}
