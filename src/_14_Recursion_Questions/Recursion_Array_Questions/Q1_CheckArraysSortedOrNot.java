package _14_Recursion_Questions.Recursion_Array_Questions;

//Q. Find if array is sorted or not.
public class Q1_CheckArraysSortedOrNot {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,9,12};

        //Method - 01 without recursion.
        System.out.println(ChekingArray(arr));

        //Method- 02 using recursion.
        System.out.println(Sorted(arr,0));
    }

    //Method-01 : Without recursion
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

    //Method 02 - Using Recursion
    static boolean Sorted(int[] arr,int index){
        if(index==arr.length-1){
            return true;
        }
        return arr[index]<=arr[index+1] && Sorted(arr,index+1);
    }
}
