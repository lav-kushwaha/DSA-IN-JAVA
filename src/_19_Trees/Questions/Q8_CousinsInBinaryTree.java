package _19_Trees.Questions;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public boolean isCousins(TreeNode root, int A, int B) {
        if (root == null) return false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isAExist = false;        
            boolean isBExist = false;        
            
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                
                if (current.val == A) isAExist = true;
                if (current.val == B) isBExist = true;
                
                // Check if A and B are siblings
                if (current.left != null && current.right != null) { 
                    if ((current.left.val == A && current.right.val == B) || 
                        (current.left.val == B && current.right.val == A)) { 
                        return false; // They are siblings, not cousins
                    }
                }
                
                // Add children to the queue
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            
            // If both A and B are found at the same level, and they are not siblings, they are cousins
            if (isAExist && isBExist) return true;
            
            // If only one of them is found, they cannot be cousins
            if (isAExist || isBExist) return false;
        }
        
        return false; // If BFS completes without finding both A and B
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        System.out.println(solution.isCousins(root1, 4, 3));  // Output: false

        // Example 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        System.out.println(solution.isCousins(root2, 5, 4));  // Output: true

        // Example 3
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.left.right = new TreeNode(4);
        System.out.println(solution.isCousins(root3, 2, 3));  // Output: false
    }
}
