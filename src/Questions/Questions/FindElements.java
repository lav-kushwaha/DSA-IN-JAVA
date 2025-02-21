package Questions.Questions;

//https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/description/
//1261. Find Elements in a Contaminated Binary Tree
//class FindElements {
//    BitSet recoveredValues;
//
//    public FindElements(TreeNode root) {
//        root.val = 0;
//        recoveredValues = new BitSet();
//        recoverTree(root);
//    }
//
//    private void recoverTree(TreeNode root) {
//        if (root == null) return;
//        recoveredValues.set(root.val);
//        if (root.left != null) {
//            root.left.val = 2 * root.val + 1;
//            recoverTree(root.left);
//        }
//        if (root.right != null) {
//            root.right.val = 2 * root.val + 2;
//            recoverTree(root.right);
//        }
//    }
//
//    public boolean find(int target) {
//        return recoveredValues.get(target);
//    }
//}