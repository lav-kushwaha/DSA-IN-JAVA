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

