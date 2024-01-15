package _07_Searching.LinearSearch.Questions;

//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
//1295.Find Numbers with Even Number of Digits
public class EvenDigits {
    public static void main(String[] args) {
         int [] arr = {12,345,12,6,7896};
         int ans = findNumbers(arr);
         System.out.println(ans);
    }
    static int findNumbers(int[] arr) {
        int count = 0;
        for (int i=0;i<arr.length;i++){
            if (even(arr[i])){
                count++;
            }
        }
        return count;
    }
    static boolean even(int nums){
        int numberofDigits = digits(nums);
        return numberofDigits%2==0;
    }
    static int digits(int num){
        if(num<0){
            num = num*-1;
        }
        if(num==0){
            return 1;
        }
        int count=0;
        while(num!=0){
            count++;
            num/=10; //num = num/10;
        }
        return count;
    }
}

//Another ways to do this questions.
    //1st way
    //  int count=0;
    //  for(int i=0;i<nums.length;i++){
    //       int numb=nums[i];
    //       String str=Integer.toString(numb);
    //       int length = str.length();
    //       if(length%2 == 0){
    //           count++;
    //       }

    //   }
    //   return count;

    //2nd way.
//        int count = 0;
//        for(int i=0;i<arr.length;i++){
//        int num = arr[i];
//        int length = 0;
//        while(num!=0){
//        length++;
//        num = num/10;
//        }
//        if(length%2==0){
//        count++;
//        }
//        }
//        return count;