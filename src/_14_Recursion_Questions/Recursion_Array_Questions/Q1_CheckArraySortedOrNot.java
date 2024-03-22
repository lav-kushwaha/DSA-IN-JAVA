package _14_Recursion_Questions.Recursion_Array_Questions;

//Q. Find if array is sorted or not.
public class Q1_CheckArraySortedOrNot {
    public static void main(String[] args) {
        int[] arr = {1,2,4,3,9,12};
        boolean ans = ChekingArray(arr);
        System.out.println(ans);
    }

    static boolean ChekingArray(int[] arr){
       boolean ans = true;
       for(int i=0;i<arr.length-1;i++){
           for(int j=i;j<=i+1;j++){
               if(arr[i]>arr[j]){
                   ans = false;
                   break;
               }
           }
       }
       return ans;
    }
}
