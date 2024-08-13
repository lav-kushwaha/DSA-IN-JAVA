package _24_Intro_To_HashMap_And_HashTable;

import java.util.LinkedList;

public class HashMap<K, V> {
    // Initial capacity of the HashMap
    private static final int INITIAL_CAPACITY = 16;
    // Load factor for resizing
    private static final float LOAD_FACTOR = 0.75f;

    // Array of buckets where each bucket is a LinkedList of Node
    private LinkedList<Node<K, V>>[] buckets;
    private int size;

    // Node class representing an entry in the HashMap
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor to initialize the HashMap with the initial capacity
    public HashMap() {
        this(INITIAL_CAPACITY);
    }

    // Constructor to initialize the HashMap with a specified capacity
    public HashMap(int capacity) {
        buckets = new LinkedList[capacity];
        size = 0;
    }

    // Hash function to calculate the index for a given key
    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    // Method to put a key-value pair into the HashMap
    public void put(K key, V value) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        // Check if the key already exists in the bucket
        for (Node<K, V> node : buckets[index]) {
            if (node.key.equals(key)) {
                node.value = value; // Update the value
                return;
            }
        }

        // Key does not exist, add a new node to the bucket
        buckets[index].add(new Node<>(key, value));
        size++;

        // Check if the load factor is exceeded and resize if necessary
        if ((float) size / buckets.length > LOAD_FACTOR) {
            resize();
        }
    }

    // Method to get the value associated with a given key
    public V get(K key) {
        int index = getIndex(key);
        if (buckets[index] != null) {
            for (Node<K, V> node : buckets[index]) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }
        }
        return null; // Key not found
    }

    // Method to remove a key-value pair from the HashMap
    public void remove(K key) {
        int index = getIndex(key);
        if (buckets[index] != null) {
            Node<K, V> prev = null;
            for (Node<K, V> node : buckets[index]) {
                if (node.key.equals(key)) {
                    if (prev == null) {
                        buckets[index].removeFirst();
                    } else {
                        prev.next = node.next;
                    }
                    size--;
                    return;
                }
                prev = node;
            }
        }
    }

    // Method to resize the HashMap when the load factor is exceeded
    private void resize() {
        LinkedList<Node<K, V>>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        size = 0;

        // Rehash all the entries and insert them into the new buckets
        for (LinkedList<Node<K, V>> bucket : oldBuckets) {
            if (bucket != null) {
                for (Node<K, V> node : bucket) {
                    put(node.key, node.value);
                }
            }
        }
    }

    // Method to get the number of key-value pairs in the HashMap
    public int size() {
        return size;
    }

    // Method to check if the HashMap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to clear the HashMap
    public void clear() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        size = 0;
    }

    // Method to check if a key exists in the HashMap
    public boolean containsKey(K key) {
        int index = getIndex(key);
        if (buckets[index] != null) {
            for (Node<K, V> node : buckets[index]) {
                if (node.key.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 3);

        System.out.println(map.get("apple"));   // Output: 1
        System.out.println(map.get("banana"));  // Output: 2
        System.out.println(map.size());         // Output: 3

        map.remove("banana");
        System.out.println(map.get("banana"));  // Output: null
        System.out.println(map.size());         // Output: 2

        System.out.println(map.containsKey("orange")); // Output: true
        System.out.println(map.containsKey("banana")); // Output: false

        map.clear();
        System.out.println(map.size());         // Output: 0
        System.out.println(map.isEmpty());      // Output: true
    }
}
