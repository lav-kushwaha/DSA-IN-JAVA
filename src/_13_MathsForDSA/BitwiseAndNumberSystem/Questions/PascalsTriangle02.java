package _11_MathsForDSA.BitwiseAndNumberSystem.Questions;
//sum of nth row in pascals triangle - by k.k
public class PascalsTriangle02 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(RowSum(n));
    }
    static int RowSum(int n){
        int ans = 0;
        for(int i=0;i<n;i++){
            ans =(1<<(n-1));
        }
        return ans;
    }

}
