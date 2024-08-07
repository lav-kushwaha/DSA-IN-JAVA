package Questions;

class SwapKth {
    void swapKth(int arr[], int N, int K) {
        if (K > 0 && K <= N) {
            // Swap Kth element from the beginning with Kth element from the end
            int temp = arr[K - 1];
            arr[K - 1] = arr[N - K];
            arr[N - K] = temp;
        }
    }

}