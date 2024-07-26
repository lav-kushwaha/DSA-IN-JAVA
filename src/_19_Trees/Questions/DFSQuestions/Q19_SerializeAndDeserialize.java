package _19_Trees.Questions.DFSQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
//297. Serialize and Deserialize Binary Tree

public class Q19_SerializeAndDeserialize {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //You just need to ensure that a binary tree can be serialized to a string
    public List<String> serialize(TreeNode node) {
        List<String> list = new ArrayList<>();
        helper(node, list);
        return list;
    }

    void helper(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("null");
            return;
        }

        list.add(String.valueOf(node.val));//converting int to string.
        helper(node.left, list);
        helper(node.right, list);
    }

    //this string can be deserialized to the original tree structure.
    public TreeNode deserialize(List<String> list) {
        Collections.reverse(list);//Here, we did reverse because we want to remove first element from the end of list.
        return helper2(list);
    }

    private TreeNode helper2(List<String> list) {
        String val = list.remove(list.size() - 1);

        if (val.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = helper2(list);
        node.right = helper2(list);
        return node;
    }

    public static void main(String[] args) {
        Q19_SerializeAndDeserialize serDeser = new Q19_SerializeAndDeserialize();

        // Create a sample tree:
        //     1
        //    / \
        //   2   3
        //      / \
        //     4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Serialize the tree
        List<String> serializedTree = serDeser.serialize(root);
        System.out.println("Serialized Tree: " + serializedTree);

        // Deserialize the list back to the tree
        TreeNode deserializedRoot = serDeser.deserialize(serializedTree);

        // Serialize again to verify
        List<String> verifySerialization = serDeser.serialize(deserializedRoot);
        System.out.println("Deserialized Tree: " + verifySerialization);
    }
}
