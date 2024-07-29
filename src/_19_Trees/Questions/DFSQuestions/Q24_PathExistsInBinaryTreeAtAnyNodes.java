package _19_Trees.Questions.DFSQuestions;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

//Q. Find the possible path which is exit.
public class Q24_PathExistsInBinaryTreeAtAnyNodes {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countPath(TreeNode root, int target) {
        List<Integer> path = new LinkedList<>();

        return helper(root, target, path);
    }

    private int helper(TreeNode node, int target, List<Integer> path) {
        if (node == null) return 0;

        path.add(node.val);
        int count = 0;
        int sum = 0;

        // Count the number of valid paths
        ListIterator<Integer> itr = path.listIterator(path.size());
        while (itr.hasPrevious()) { // hasPrevious(): This method returns true when the list has more elements to traverse while traversing in the reverse direction
            sum += itr.previous(); // previous(): This method returns the previous element of the list and shifts the cursor one position backward.
            if (sum == target) {
                count++;
            }
        }

        count += helper(node.left, target, path) + helper(node.right, target, path);

        // backtrack
        path.remove(path.size() - 1);
        return count;
    }

    //List of path
    public List<List<Integer>> findPaths(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findPathsHelper(root, targetSum, path, paths);
        return paths;
    }

    private void findPathsHelper(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> paths) {
        if (node == null) return;

        // Add the current node to the path
        path.add(node.val);

        // If it's a leaf node and the path sum equals the target sum, add the path to the result
        if (node.left == null && node.right == null && targetSum == node.val) {
            paths.add(new ArrayList<>(path));
        } else {
            // Continue to explore the left and right subtrees
            findPathsHelper(node.left, targetSum - node.val, path, paths);
            findPathsHelper(node.right, targetSum - node.val, path, paths);
        }

        // Backtrack
        path.remove(path.size() - 1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(1);
        root.right.left.left = new TreeNode(11);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(2);
        root.right.right.left.right = new TreeNode(2);
        root.right.right.left.right.left = new TreeNode(16);

        Q24_PathExistsInBinaryTreeAtAnyNodes result = new Q24_PathExistsInBinaryTreeAtAnyNodes();
        int target = 4;
        int total = result.countPath(root, target);

        System.out.println("Total paths with sum " + target + " is : " + total);

        List<List<Integer>> paths = result.findPaths(root, 4);
        System.out.println(paths); // Expected output: [[1, 3], [1, 2, 1], [2, 2]]


    }
}
