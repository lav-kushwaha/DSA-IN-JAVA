package _11_MathsForDSA.BitwiseAndNumberSystem.Questions;
public class RangeXOR {
    public static void main(String[] args) {
        //range XOR for a,b= XOR(b) ^ XOR(a-1);
        int a = 3;
        int b = 9;
        int ans = xor(b) ^ xor(a-1);
        System.out.println(ans);


        //only for check, will give TLE for large numbers.
//        int ans1 = 0;
//        for(int i=a;i<=b;i++){
//            ans1 ^=i;
//        }
//        System.out.println(ans1);


    }

    //this gives XOR from 0 to a
    static int xor(int a){
        if(a%4==0){
            return a;
        }
        if(a%4==1){
            return 1;
        }
        if(a%4==2){
            return a+1;
        }
        if(a%4==3){
            return 0;
        }
        return 0;
    }
}
