package _14_Recursion_Questions.Backtracking.Backtracking_Questions;

public class N_Queens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board, 0));
    }
    static int queens(boolean[][] board, int row) {
        // If all queens are placed, display the board and return 1 to count the valid placement
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;
        // Place the queen and check for every column in the current row
        for (int col = 0; col < board.length; col++) {
            // Place the queen if it is safe
            if (isSafe(board, row, col)) {
                board[row][col] = true; // Mark the cell as occupied by a queen
                // Recursively place queens in the next row
                count += queens(board, row + 1);
                board[row][col] = false; // Backtrack: Remove the queen from the current cell
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // Check if there is no queen in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // Check the diagonal on the left side
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // Check the diagonal on the right side
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        // If no conflicts, it's safe to place the queen in this cell
        return true;
    }

    //display
    private static void display(boolean[][] board) {
        // Display the current configuration of the board
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q "); // Print 'Q' if the cell is occupied by a queen
                } else {
                    System.out.print("X "); // Print 'X' if the cell is empty
                }
            }
            System.out.println();
        }
    }
}
