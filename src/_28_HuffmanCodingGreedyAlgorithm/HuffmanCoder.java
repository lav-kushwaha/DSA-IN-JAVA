package _28_HuffmanCodingGreedyAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoder {
    private HashMap<Character, String> encoder;
    private HashMap<String, Character> decoder;

    private class Node implements Comparable<Node> {
        Character data;
        int cost; // frequency
        Node left;
        Node right;

        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public HuffmanCoder(String feeder) {
        buildHuffmanTree(feeder);
    }

    public void buildHuffmanTree(String feeder) {
        // Build frequency map.
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : feeder.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Create a priority queue (min-heap) for the Huffman tree
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(new Node(entry.getKey(), entry.getValue()));
        }

        // Build the Huffman tree.
        //remove and combine while the heap size remain one.
        while (minHeap.size() > 1) {
            Node first = minHeap.poll();
            Node second = minHeap.poll();

            Node newNode = new Node(null, first.cost + second.cost);

            newNode.left = first;
            newNode.right = second;

            minHeap.offer(newNode);
        }

        // The root node of the Huffman tree
        Node root = minHeap.poll();

        // Initialize encoder and decoder
        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        //initially in encoder pass empty string.
        initEncoderDecoder(root, "");
    }

    private void initEncoderDecoder(Node node, String code) {
        if (node == null) return;

        //i'm at leaf node
        if (node.left == null && node.right == null) {
            encoder.put(node.data, code);
            decoder.put(code, node.data);
        }

        //whenever I'll go left, i'll add 0 and whenever I'll go right I'll add 1.
        //recursion
        initEncoderDecoder(node.left, code + "0");
        initEncoderDecoder(node.right, code + "1");
    }

    public StringBuilder encode(String source) {
        StringBuilder encodedString = new StringBuilder();

        //iteration
        for (char ch : source.toCharArray()) {
            encodedString.append(encoder.get(ch));
        }

        return encodedString;//return encoded string
    }

    public StringBuilder decode(String codeString) {
        if (codeString == null || codeString.isEmpty()) {
            return new StringBuilder();
        }

        StringBuilder decodedString = new StringBuilder();
        StringBuilder currentCode = new StringBuilder();

        //iteration
        for (char bit : codeString.toCharArray()) {
            currentCode.append(bit);
            if (decoder.containsKey(currentCode.toString())) {
                decodedString.append(decoder.get(currentCode.toString()));
                currentCode.setLength(0); // Reset the current code
            }
        }

        return decodedString;//return decoded string
    }

    public static void main(String[] args) throws Exception {
        String str = "abbccda";
        HuffmanCoder huff = new HuffmanCoder(str);

        // Encode the string
        StringBuilder encoded = huff.encode(str);
        System.out.println("Encoded: " + encoded);

        // Decode the encoded string
        StringBuilder decoded = huff.decode(encoded.toString());
        System.out.println("Decoded: " + decoded);
    }
}
