package Questions.Questions;

//https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
//515. Find Largest Value in Each Tree Row

//class largestValues {
//    private List<Integer> res;
//    public List<Integer> largestValues(TreeNode root) {
//        res = new ArrayList<>();
//        dfs(root, 0);
//
//        return res;
//    }
//
//    private void dfs(TreeNode root, int level) {
//        if (root != null) {
//            int val = root.val;
//
//            if (res.size() == level)
//                res.add(val);
//            else
//                res.set(level, Math.max(res.get(level), val));
//
//            dfs(root.left, level + 1);
//            dfs(root.right, level + 1);
//        }
//    }
//}