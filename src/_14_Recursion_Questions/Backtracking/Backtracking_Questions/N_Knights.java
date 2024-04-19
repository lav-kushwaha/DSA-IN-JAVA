package _14_Recursion_Questions.Backtracking.Backtracking_Questions;

public class N_Knights {
    public static void main(String[] args) {
        // Initialize the board size
        int n = 4;
        // Initialize the chessboard.
        boolean[][] board = new boolean[n][n];
        // Start placing knights on the chessboard
        knights(board, 0, 0, 4);
    }

    // Method to place knights on the chessboard using backtracking.
    static void knights(boolean[][] board, int row, int col, int knights) {
        // Base case: All knights have been placed
        if (knights == 0) {
            // Display the current configuration of the board
            display(board);
            System.out.println();
            return;
        }

        // Base case: Reached end of board
        if (row == board.length - 1 && col == board.length) {
            return;
        }

        // Move to the next row if end of current row is reached
        if (col == board.length) {
            knights(board, row + 1, 0, knights);
            return;
        }

        // Attempt to place a knight at the current position
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knights(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }
        // Try placing a knight at the next column
        knights(board, row, col + 1, knights);
    }

    // Method to check if it's safe to place a knight at a given position.
    static boolean isSafe(boolean[][] board, int row, int col) {
         // Check if neighboring positions have already been occupied by knights.
         if(isValid(board,row-2,col-1)){
                if(board[row-2][col-1]){
                    return false;
                }
             }

         if(isValid(board,row-1,col-2)){
             if(board[row-1][col-2] ){
                 return false;
             }
         }

         if(isValid(board,row-2,col+1)){
             if(board[row-2][col+1] ){
                 return false;
             }
         }

         if(isValid(board,row-1,col+2)){
             if(board[row-1][col+2] ){
                 return false;
             }
         }

         //if is safe means there is not knight return true.
         return true;
    }

    // do  not repeat yourself, hence created this function.
     static boolean isValid(boolean[][] board, int row, int col) {
         return row >= 0 && row < board.length && col >= 0 && col < board.length;
     }

     static void display(boolean[][] board) {
        // Display the current configuration of the board.
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("K "); // Print 'K' if the cell is occupied by a queen.
                } else {
                    System.out.print("X "); // Print 'X' if the cell is empty.
                }
            }
            System.out.println();
        }
    }

}
