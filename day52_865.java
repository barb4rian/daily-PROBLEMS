class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    
    private Result dfs(TreeNode node) {
        if (node == null) return new Result(null, 0);
        
        Result l = dfs(node.left);
        Result r = dfs(node.right);
        
        if (l.d > r.d) return new Result(l.node, l.d + 1);
        if (l.d < r.d) return new Result(r.node, r.d + 1);
        return new Result(node, l.d + 1);
    }
    
    class Result {
        TreeNode node;
        int d;
        Result(TreeNode n, int depth) {
            node = n;
            d = depth;
        }
    }
}