package _19_Trees.Questions.DFSQuestions;

import java.util.Arrays;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
//105. Construct Binary Tree from Preorder and Inorder Traversal


public class Q18_BTfromPreorderandInorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Base case: if the preorder array is empty, return null
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // The root node is the first element in the preorder array
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        // Find the index of the root in the inorder array
        int rootIndexInInorder = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                rootIndexInInorder = i;
                break;
            }
        }

        // Split the arrays into left and right subtrees
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, rootIndexInInorder + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndexInInorder);
        int[] rightPreorder = Arrays.copyOfRange(preorder, rootIndexInInorder + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootIndexInInorder + 1, inorder.length);

        // Recursively build the left and right subtrees
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        //or
        //node.left = buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        //node.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));

        return root;
    }

    // Helper method to print the tree (preorder traversal)
    public void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }

    public static void main(String[] args) {
        Q18_BTfromPreorderandInorderTraversal treeBuilder = new Q18_BTfromPreorderandInorderTraversal();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = treeBuilder.buildTree(preorder, inorder);

        System.out.println("Preorder traversal of the constructed tree:");
        treeBuilder.printTree(root);
    }
}


//Notes:

//Time Complexity: This solution has a time complexity of O(n^2) due to the linear search for the root index in the inorder array.
//This can be improved to O(n) by using a hash map to store the indices of elements in the inorder array.

//Space Complexity: The space complexity is O(n) due to the space required for the recursive call stack.