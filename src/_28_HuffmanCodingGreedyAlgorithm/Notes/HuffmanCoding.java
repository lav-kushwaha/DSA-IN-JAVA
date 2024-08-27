package _28_HuffmanCodingGreedyAlgorithm.Notes;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;

// Node class representing a node in the Huffman Tree
class HuffmanNode {
    char character;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;

    HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    HuffmanNode(int frequency) {
        this.character = '\0'; // '\0' represents an internal node (non-leaf)
        this.frequency = frequency;
    }
}

// Comparator class to compare Huffman nodes based on their frequency
class HuffmanComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.frequency - y.frequency;
    }
}

public class HuffmanCoding {

    // Main function to encode input text using Huffman Coding
    public static void encode(String text) {
        // Calculate the frequency of each character in the input text
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char character : text.toCharArray()) {
            frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
        }

        // Priority Queue to hold the Huffman nodes, ordered by frequency
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(frequencyMap.size(), new HuffmanComparator());

        // Create a leaf node for each character and add it to the priority queue
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        // Build the Huffman Tree
        while (priorityQueue.size() > 1) {
            // Remove the two nodes of the highest priority (lowest frequency)
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            // Create a new internal node with these two nodes as children and add it to the queue
            HuffmanNode parentNode = new HuffmanNode(left.frequency + right.frequency);
            parentNode.left = left;
            parentNode.right = right;
            priorityQueue.add(parentNode);
        }

        // The remaining node is the root of the Huffman Tree
        HuffmanNode root = priorityQueue.poll();

        // Generate Huffman Codes from the Huffman Tree
        Map<Character, String> huffmanCodeMap = new HashMap<>();
        generateHuffmanCodes(root, "", huffmanCodeMap);

        // Display the Huffman Codes
        System.out.println("Huffman Codes for each character:");
        for (Map.Entry<Character, String> entry : huffmanCodeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Encode the input text using the generated Huffman Codes
        StringBuilder encodedText = new StringBuilder();
        for (char character : text.toCharArray()) {
            encodedText.append(huffmanCodeMap.get(character));
        }

        // Display the original and encoded text
        System.out.println("\nOriginal text: " + text);
        System.out.println("Encoded text: " + encodedText.toString());
    }

    // Recursive function to generate Huffman Codes
    private static void generateHuffmanCodes(HuffmanNode root, String code, Map<Character, String> huffmanCodeMap) {
        if (root == null) {
            return;
        }

        // Check if it is a leaf node
        if (root.left == null && root.right == null) {
            huffmanCodeMap.put(root.character, code);
        }

        // Recurse to the left and right children
        generateHuffmanCodes(root.left, code + "0", huffmanCodeMap);
        generateHuffmanCodes(root.right, code + "1", huffmanCodeMap);
    }

    public static void main(String[] args) {
        String text = "huffman coding algorithm";
        encode(text);
    }
}
