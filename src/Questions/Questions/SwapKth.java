package Questions.Questions;

import java.util.Arrays;

class SwapKth {
   static void swapKth(int arr[], int N, int K) {
        if (K > 0 && K <= N) {
            // Swap Kth element from the beginning with Kth element from the end
            int temp = arr[K - 1];
            arr[K - 1] = arr[N - K];
            arr[N - K] = temp;
        }
    }

    public static void main(String[] args) {
       int [] arr = {1,2,3,4,5,6};
       int K = 2;
       swapKth(arr,arr.length,K);
       System.out.println(Arrays.toString(arr));
    }
}