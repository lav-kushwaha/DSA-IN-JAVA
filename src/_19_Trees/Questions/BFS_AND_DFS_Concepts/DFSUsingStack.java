package _19_Trees.Questions.BFS_AND_DFS_Concepts;

import java.util.Stack;

public class DFSUsingStack {
    static class TreeNode{
        int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    //Dfs using stack (iterative)
    public void preOrder(TreeNode root){
        if(root==null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            System.out.print(current.val + " ");

            //we are adding right node first.
            if(current.right!=null){
                stack.push(current.right);
            }

            //we are adding left node last. so, we can remove at first. bcz in preOrder (N-L-R)
            if(current.left!=null){
                stack.push(current.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);

        //left subtree
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);

        root.right = new TreeNode(9);
        root.right.left = new TreeNode(18);

        DFSUsingStack solution = new DFSUsingStack();
        solution.preOrder(root);
    }
}
