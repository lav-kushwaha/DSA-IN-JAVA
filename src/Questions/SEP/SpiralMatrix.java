package Questions.SEP;
import java.util.Arrays;

//https://leetcode.com/problems/spiral-matrix-iv/?envType=daily-question&envId=2024-09-09
//2326. Spiral Matrix IV

class SpiralMatrix {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val;
            this.next = null; }
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int[] row : matrix) Arrays.fill(row, -1);// Initialize the matrix with -1

        int topRow = 0, bottomRow = m - 1, leftCol = 0, rightCol = n - 1;
        while (head != null) {

            // Fill from left to right along the top row
            for (int col = leftCol; col <= rightCol; col++) {
                if (head == null) break;
                matrix[topRow][col] = head.val;
                head = head.next;
            }
            topRow++;  // Move the top boundary down

            // Fill from top to bottom along the right column
            for (int row = topRow; row <= bottomRow; row++) {
                if (head == null) break;
                matrix[row][rightCol] = head.val;
                head = head.next;
            }
            rightCol--;  // Move the right boundary left

            // Fill from right to left along the bottom row
            for (int col = rightCol; col >= leftCol; col--) {
                if (head == null) break;
                matrix[bottomRow][col] = head.val;
                head = head.next;
            }
            bottomRow--;  // Move the bottom boundary up

            // Fill from bottom to top along the left column
            for (int row = bottomRow; row >= topRow; row--) {
                if (head == null) break;
                matrix[row][leftCol] = head.val;
                head = head.next;
            }
            leftCol++;  // Move the left boundary right
        }

        return matrix;
    }

    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();

        int m = 3, n = 4;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}; // Linked list values

        // Create a linked list from the array
        ListNode head = solution.createLinkedList(arr);

        // Generate the spiral matrix
        int[][] result = solution.spiralMatrix(m, n, head);

        solution.printMatrix(result);
    }
}
