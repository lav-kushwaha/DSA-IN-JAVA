package Questions.Questions;

//https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
// Cells with Odd Values in a Matrix
public class Cells_with_Odd_Values_in_a_Matrix {
    public static void main(String[] args) {
        int[][] indices = {
                            {0,1},
                            {1,1}
                        };
        int m = 2;
        int n = 3;

        int ans = oddCells(m, n, indices);//calling a functions with arguments
        System.out.println(ans);//print ans
    }

    static int oddCells(int m, int n, int[][] indices){
           int [] rows = new int[m];
           int [] cols = new int[n];

           for(int i=0;i<indices.length;i++){
                 int rowIndex = indices[i][0];
                 int colIndex = indices[i][1];

                 rows[rowIndex]++;
                 cols[colIndex]++;

           }

           //oddelement count
           int oddElementCount = 0;

           for(int i=0;i<m;i++){
               for(int j=0;j<n;j++){
                   if(rows[i] + cols[j] % 2 !=0){
                       oddElementCount++;
                   }
               }
           }

           return oddElementCount;
    }
}
