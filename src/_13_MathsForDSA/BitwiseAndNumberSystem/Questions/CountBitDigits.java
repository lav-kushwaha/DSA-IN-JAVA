package _11_MathsForDSA.BitwiseAndNumberSystem.Questions;
//Q.Find the no. of digits in base b.
public class CountBitDigits {
    public static void main(String[] args) {
        //1st method
//        int n = 6;
//        int count = 0;
//        while(n>0){
//            n = n>>1;//right shift operator
//            count++;//counting the bits digits.
//        }
//        System.out.println(count);

        //2nd method.
        int n = 10;//1010
        int b = 2;//binary
        int ans = (int)(Math.log(n)/Math.log(b))+1;
        System.out.println(ans);//4 digits in binary

    }
}
