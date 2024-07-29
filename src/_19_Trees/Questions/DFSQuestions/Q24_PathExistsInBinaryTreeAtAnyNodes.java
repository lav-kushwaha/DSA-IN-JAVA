package _19_Trees.Questions.DFSQuestions;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

//Q. Find the possible path which is exit.
public class Q24_PathExistsInBinaryTreeAtAnyNodes {
   static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public int FindPathExist(TreeNode root, int target) {
        List<Integer> path = new LinkedList<>();

        return helper(root,target,path);
    }

    private int helper(TreeNode node, int target,List<Integer> path) {
        if (node == null) return 0;

        path.add(node.val);
        int count = 0;
        int sum = 0;

        // Count the number of valid paths
        ListIterator<Integer> itr = path.listIterator(path.size());
        while (itr.hasPrevious()) {//hasPrevious(): This method returns true when the list has more elements to traverse while traversing in the reverse direction
            sum += itr.previous(); //previous():This method returns the previous element of the list and shifts the cursor one position backward.
            if (sum == target) {
                count++;
            }
        }

        count += helper(node.left, target, path) + helper(node.right, target, path);

        //backtrack
        path.remove(path.size() - 1);
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(2);
        root.right.right.left.right = new TreeNode(2);
        root.right.right.left.right.left = new TreeNode(2);

        Q24_PathExistsInBinaryTreeAtAnyNodes finder = new Q24_PathExistsInBinaryTreeAtAnyNodes();
        int target = 4;
        int total = finder.FindPathExist(root, target);

        System.out.println("Path exists: " + total);
    }
}
