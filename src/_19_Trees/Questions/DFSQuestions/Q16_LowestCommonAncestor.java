package _19_Trees.Questions.DFSQuestions;

public class Q16_LowestCommonAncestor {

    // Definition for a binary tree node.
    static class TreeNode{
        int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    //Method to find the LowestCommonAncestor.
    public TreeNode LowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return null;
        }

        //case 1: found one of the node no need to go down return from here.
        if(node == p || node == q){
            return node;
        }

       // check left and right go down.
        TreeNode left = LowestCommonAncestor(node.left,p,q);
        TreeNode right = LowestCommonAncestor(node.right,p,q);

        //case 2:if we found answer in the both left and right return the node.
        if(left!=null && right!=null){
            return node;
        }

        //case 3: if left side is null return right same for right side.
        return left==null?right:left;
    }

    public static void main(String[] args) {

        //root of tree
        TreeNode root = new TreeNode(3);

        //left subtree
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right =  new TreeNode(2);
        root.left.right.left =  new TreeNode(7);
        root.left.right.right =  new TreeNode(4);

        //right subtree
        root.right = new TreeNode(1);
        root.right.left =  new TreeNode(6);
        root.right.right = new TreeNode(8);

        Q16_LowestCommonAncestor solution = new Q16_LowestCommonAncestor();
        TreeNode ans  = solution.LowestCommonAncestor(root, root.left, root.left.right.right );
        System.out.println(ans.val);

    }
}
