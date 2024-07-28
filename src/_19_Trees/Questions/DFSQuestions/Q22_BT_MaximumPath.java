package _19_Trees.Questions.DFSQuestions;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/
//124. Binary Tree Maximum Path Sum

public class Q22_BT_MaximumPath {

    static class TreeNode{
       private int val;
       private TreeNode left;
       private TreeNode right;

       public TreeNode(int val){
           this.val = val;
       }
    }

    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        helper(root);
        return ans;
    }

    private int helper(TreeNode node){
        if(node==null){
            return 0;
        }

        int left = helper(node.left);
        int right = helper(node.right);

        //if any negative node found make it 0, bcz we don't want negative path.
        // its reduce our overall answer we want maximum path.
         left = Math.max(0,left);
         right = Math.max(0,right);

        int pathSum = left + right + node.val;

        ans = Math.max(ans,pathSum);

        return Math.max(left,right) + node.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Q22_BT_MaximumPath solution = new  Q22_BT_MaximumPath();
        System.out.println("The optimal path sum is : "+solution.maxPathSum(root));
    }
}
