package Questions;

//https://www.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/0
//Check if array is sorted

class Checkarrayissorted {
    static boolean arraySortedOrNot(int[] arr, int n) {
         // code here
        for(int i = 0; i < n - 1; i++){
             if(arr[i] > arr[i+1]){
            return false;
            }
       }
       return true;
    }

     public static void main(String[] args) {
         int arr[] = {10, 20, 30, 40, 50};
         int N = 5;
         System.out.println(arraySortedOrNot(arr,N));
     }
}