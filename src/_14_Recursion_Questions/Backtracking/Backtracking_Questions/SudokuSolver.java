package _14_Recursion_Questions.Backtracking.Backtracking_Questions;
//https://leetcode.com/problems/sudoku-solver/

public class SudokuSolver {
    public static boolean solveSudoku(char[][] board) {
        int[] emptyCell = findEmptyCell(board);
        if (emptyCell == null) {
            return true; // No empty cells left, puzzle solved
        }

        //taking empty cell.
        int row = emptyCell[0];
        int col = emptyCell[1];

        // Try filling the empty cell with numbers from '1' to '9'
        for (char num = '1'; num <= '9'; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;

                // Recursively solve the rest of the puzzle
                if (solveSudoku(board)) {
                    return true;
                }

                // If no solution found, backtrack and try the next number
                board[row][col] = '.';
            }
        }

        return false; // No valid number found for this cell
    }

    public static int[] findEmptyCell(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    return new int[]{i, j};
                }
            }
        }
        return null; // If no empty cell found
    }

    public static boolean isValid(char[][] board, int row, int col, char num) {
        // Check if the number is already present in the row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Check if the number is already present in the column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check if the number is already present in the 3x3 box
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

//        System.out.println("Sudoku puzzle to solve:");
//        solver.printBoard(board);

        if (solveSudoku(board)) {
            System.out.println("\nSudoku puzzle solved:");
            printBoard(board);
        } else {
            System.out.println("No solution exists for the given puzzle.");
        }
    }
}


