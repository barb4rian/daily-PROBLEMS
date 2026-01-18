class Solution {
    int m = 0;
    
    public int longestZigZag(TreeNode root) {
        dfs(root, 0, 0);
        return m;
    }
    
    private void dfs(TreeNode n, int l, int r) {
        if (n == null) return;
        
        m = Math.max(m, Math.max(l, r));
        
        dfs(n.left, r + 1, 0);
        dfs(n.right, 0, l + 1);
    }
}