package Questions;

//https://www.geeksforgeeks.org/problems/peak-element/0
//Peak element

class PeakElement {
        public static int peakElement(int[] arr, int n) {

        int start = 0;
        int end = n - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            // Compare middle element with its end neighbor
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1; // Peak must be on the end side
            } else {
                end = mid; // Peak must be on the start side (including mid)
            }
        }

        // At the end, start and end will converge to the peak element index
        return start;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {1, 2, 3};
        int peakIndex1 = peakElement(arr1, arr1.length);
        System.out.println("Peak index for arr1: " + peakIndex1 + " (Expected: 2)");

        // Test case 2
        int[] arr2 = {1, 1, 1, 2, 1, 1, 1};
        int peakIndex2 = peakElement(arr2, arr2.length);
        System.out.println("Peak index for arr2: " + peakIndex2 + " (Expected: any of 0, 1, 3, 5, 6)");

        // Test case 3
        int[] arr3 = {10, 20, 15, 2, 23, 90, 67};
        int peakIndex3 = peakElement(arr3, arr3.length);
        System.out.println("Peak index for arr3: " + peakIndex3 + " (Expected: any of 1, 5)");
    }
}


/*
A peak element in an array is an element that is greater than or equal to its adjacent elements;
for example, in the array [1, 3, 2, 4, 1], the elements 3 and 4 are peaks.
*/