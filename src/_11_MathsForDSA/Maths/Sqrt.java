package _11_MathsForDSA.Maths;

public class Sqrt {
    public static void main(String[] args) {
        int n = 625;
        int ans = SquareRoot(n);
        System.out.println(ans);
    }
    static int SquareRoot(int n){
       int start = 0;
       int end = n;
       while (start<=end){
           int mid =  start+(end - start)/2;
           int sqr = mid*mid;
           if(sqr == n){
               return mid;
           }
           if(sqr > n){
               end = mid -1;
           }
           else {
               start = mid+1;
           }
       }
        return -1;
    }

}
