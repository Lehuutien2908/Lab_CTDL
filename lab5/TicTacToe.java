package lab5;

public class TicTacToe {
	private static final char emty = ' ';
	private char[][] board;

	public TicTacToe(char[][] board) {
		this.board = board;
	}

	public boolean checkRows() {
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] != emty && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;
			}
		}
		return false;
	}

	public boolean checkColumns() {
		for (int i = 0; i < board.length; i++) {
			if (board[0][i] != emty && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return true;
			}
		}
		return false;
	}

	public boolean checkDiagonals() {
		if (board[0][0] != emty && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return true;
		}
		if (board[0][0] != emty && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] board = { { 'X', 'O', 'X' }, { 'O', 'X', 'O' }, { 'O', 'X', 'O' } };
		TicTacToe game = new TicTacToe(board);
		if (game.checkColumns() || game.checkDiagonals() || game.checkRows()) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}
}
