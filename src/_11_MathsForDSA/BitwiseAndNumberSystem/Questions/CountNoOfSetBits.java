package _11_MathsForDSA.BitwiseAndNumberSystem.Questions;
//Q.Count no. of set bits.
public class CountNoOfSetBits {
    public static void main(String[] args) {
        //1st methdod.
//        int n = 6;
//        int count = 0;
//        while (n!=0){
//            if((n&1)==1){
//                count++;
//            }
//            n=n>>1;
//        }
//        System.out.println(count);// 2

        //convert integer to binary no.
//        int n = 10;
//        System.out.println(Integer.toBinaryString(n));//1010
        //Note:Integer.toBinaryString(n) this Integer class takes no. and converted into a binary no.

        //2nd method.
        int n = 10;
        System.out.println(SetsBit(n));
    }

     static int SetsBit(int n) {
        int count = 0;
         while(n>0){
             count++;
             n-=(n&-n);
         }

        return count;
    }
}




