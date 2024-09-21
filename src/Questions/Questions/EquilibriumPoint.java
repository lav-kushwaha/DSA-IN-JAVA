package Questions.Questions;

//Q.Equilibrium Point
//https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1?page=1&category=Arrays,Strings,Sorting,Matrix,Searching,Recursion,Binary%20Search&sortBy=submissions

public class EquilibriumPoint {
    public static void main(String[] args) {
        int A[] = {1,3,5,2,2};
        long ans = equilibriumPoint(A,A.length);
        System.out.println(ans);
    }
    
    public static int equilibriumPoint(int[] a, int n) {
        // Your code here
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        long Lsum = 0;
        for (int i = 0; i < n; i++) {
            if (Lsum == sum - a[i]) {
                return i + 1; // Indexing starts from 1
            }
            Lsum += a[i];
            sum -= a[i];
        }
        return -1;// No equilibrium index found.
    }
}
