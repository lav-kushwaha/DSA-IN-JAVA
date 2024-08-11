package _23_Heap_DataStructure.Heaps.HeapifyAndBuildHeap;

import java.util.ArrayList;
import java.util.Arrays;

public class UnsortedArrayToMaxHeap {
    private ArrayList<Integer> heap;

    public UnsortedArrayToMaxHeap(ArrayList<Integer> array) {
        this.heap = array;
        buildMaxHeap(); // Convert the unsorted array into a max-heap
    }

    // Method to build a max heap from the unsorted array
    private void buildMaxHeap() {
        int n = heap.size();

        // Start from the last non-leaf node and move up to the root
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(i, n);
        }
    }

    // Heapify the subtree rooted at index `i`
    private void heapify(int i, int n) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child index
        int right = 2 * i + 2; // Right child index

        // If the left child is larger than the root
        if (left < n && heap.get(left) > heap.get(largest)) {
            largest = left;
        }

        // If the right child is larger than the current largest
        if (right < n && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        // If the largest is not the root, swap and continue heapifying
        if (largest != i) {
            swap(i, largest);
            heapify(largest, n);
        }
    }

    // Swap two elements in the array
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Method to get the heap
    public ArrayList<Integer> getHeap() {
        return heap;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(3, 5, 9, 6, 8, 20, 10, 12, 18, 9));

        UnsortedArrayToMaxHeap unsortedArrayToMaxHeap = new UnsortedArrayToMaxHeap(array);

        System.out.println("Max Heap: " + unsortedArrayToMaxHeap.getHeap());
    }
}
