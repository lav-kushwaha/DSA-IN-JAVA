package _23_Heap_DataStructure.Heaps;

import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> list;

    public MinHeap() {
        list = new ArrayList<>();
    }

    // Swap two elements in the heap based on their indices
    private void swap(int first, int second) {
        int temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    // Get the index of the parent of the current node
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Get the index of the left child of the current node
    private int left(int index) {
        return index * 2 + 1;
    }

    // Get the index of the right child of the current node
    private int right(int index) {
        return index * 2 + 2;
    }

    // Insert a new value into the heap and maintain the heap property
    public void insert(int value) {
        list.add(value);
        heapifyUp(list.size() - 1); // Restore the heap property from bottom to top
    }

    // Heapify up: move the element at the given index up to its correct position
    private void heapifyUp(int index) {
        if (index == 0) return; // Base case: root reached

        int p = parent(index);

        // Swap with parent if current value is smaller
        if (list.get(index) < list.get(p)) {
            swap(index, p); // Swap current element with parent if it's smaller
            heapifyUp(p); // Recursive call on the parent
        }
    }

    // Remove and return the minimum element (root) from the heap
    public int remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from an empty heap");
        }

        int rootValue = list.get(0); // Store the root value to return later
        int lastValue = list.remove(list.size() - 1); // Remove the last element

        // If the heap is not empty after removal, move the last element to the root
        if (!list.isEmpty()) {
            list.set(0, lastValue);
            heapifyDown(0); // Restore the heap property from top to bottom
        }
        return rootValue;
    }

    // Heapify down: move the element at the given index down to its correct position
    private void heapifyDown(int index) {
        int min = index;
        int leftChild = left(index);
        int rightChild = right(index);

        // If the left child is smaller than the current element, update min
        if (leftChild < list.size() && list.get(leftChild) < list.get(min)) {
            min = leftChild;
        }

        // If the right child is smaller than the current element, update min
        if (rightChild < list.size() && list.get(rightChild) < list.get(min)) {
            min = rightChild;
        }

        // If the smallest element is not the current element, swap and recurse
        if (min != index) {
            swap(min, index);
            heapifyDown(min);
        }
    }

    // Perform heap sort and return a sorted list of elements
    public ArrayList<Integer> heapSort() throws Exception {
        ArrayList<Integer> sortedList = new ArrayList<>();
        while (!list.isEmpty()) {
            sortedList.add(this.remove()); // Continuously remove the min element and add to sortedList
        }
        return sortedList;
    }

    public static void main(String[] args) throws Exception {
        MinHeap minHeap = new MinHeap();
        // Min Heap
        minHeap.insert(12);
        minHeap.insert(32);
        minHeap.insert(42);
        minHeap.insert(62);
        minHeap.insert(2);

        System.out.println(minHeap.remove()); // Expected to print the smallest element
        System.out.println(minHeap.heapSort()); // Expected to print sorted elements
    }
}
