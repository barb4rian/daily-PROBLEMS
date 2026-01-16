class Solution {
    public int goodNodes(TreeNode r) {
        return dfs(r, r.val);
    }
    
    private int dfs(TreeNode n, int m) {
        if (n == null) return 0;
        
        int c = 0;
        if (n.val >= m) {
            c = 1;
            m = n.val;
        }
        
        return c + dfs(n.left, m) + dfs(n.right, m);
    }
}