package Questions.SEP;

import java.util.*;

//https://leetcode.com/problems/all-oone-data-structure/description/
//432. All O`one Data Structure


public class AllOne {
    private class Node {
        int count;
        LinkedList<String> keys;
        Node prev, next;

        Node(int c) {
            count = c;
            keys = new LinkedList<>();
        }
    }

    // HashMap to store key -> node in the doubly linked list
    private Map<String, Node> mp;

    // Head and tail pointers for the doubly linked list
    private Node head, tail;

    public AllOne() {
        // Initialize head and tail dummy nodes for the doubly linked list
        head = new Node(0);
        tail = head;
        mp = new HashMap<>();
    }

    // Add a new node with count `count` after node `prevNode`
    private Node addNodeAfter(Node prevNode, int count) {
        Node newNode = new Node(count);
        newNode.next = prevNode.next;
        newNode.prev = prevNode;

        if (prevNode.next != null) {
            prevNode.next.prev = newNode;
        }
        prevNode.next = newNode;

        if (tail == prevNode) {
            tail = newNode;
        }

        return newNode;
    }

    // Remove the node from the doubly linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (tail == node) {
            tail = node.prev;
        }
    }

    public void inc(String key) {
        if (!mp.containsKey(key)) {
            // Key doesn't exist, add it to the list after the head with count 1
            if (head.next == null || head.next.count != 1) {
                addNodeAfter(head, 1);
            }
            head.next.keys.addFirst(key);
            mp.put(key, head.next);
        } else {
            // Key exists, move it to the next count
            Node curNode = mp.get(key);
            int curCount = curNode.count;

            if (curNode.next == null || curNode.next.count != curCount + 1) {
                addNodeAfter(curNode, curCount + 1);
            }

            curNode.next.keys.addFirst(key);
            mp.put(key, curNode.next);
            curNode.keys.remove(key);

            if (curNode.keys.isEmpty()) {
                removeNode(curNode);
            }
        }
    }

    // Decrement the count for a key
    public void dec(String key) {
        Node curNode = mp.get(key);
        int curCount = curNode.count;

        // Remove the key from the current node
        curNode.keys.remove(key);

        if (curCount == 1) {
            // If count is 1, remove it from the map
            mp.remove(key);
        } else {
            // Move it to the previous count
            if (curNode.prev == head || curNode.prev.count != curCount - 1) {
                addNodeAfter(curNode.prev, curCount - 1);
            }
            curNode.prev.keys.addFirst(key);
            mp.put(key, curNode.prev);
        }

        // Remove the current node if it has no more keys
        if (curNode.keys.isEmpty()) {
            removeNode(curNode);
        }
    }

    // Get the key with the maximum count
    public String getMaxKey() {
        return (tail == head) ? "" : tail.keys.getFirst();
    }

    // Get the key with the minimum count
    public String getMinKey() {
        return (head.next == null) ? "" : head.next.keys.getFirst();
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        System.out.println(allOne.getMaxKey()); // Outputs "c"
        System.out.println(allOne.getMinKey()); // Outputs "a"
        allOne.dec("c");
        allOne.dec("c");
        System.out.println(allOne.getMaxKey()); // Outputs "b"
        System.out.println(allOne.getMinKey()); // Outputs "a"
    }
}
