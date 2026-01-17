class Solution {
    public int pathSum(TreeNode r, int t) {
        Map<Long, Integer> m = new HashMap<>();
        m.put(0L, 1);
        return dfs(r, 0L, t, m);
    }
    
    private int dfs(TreeNode n, long c, int t, Map<Long, Integer> m) {
        if (n == null) return 0;
        
        c += n.val;
        int v = m.getOrDefault(c - t, 0);
        
        m.put(c, m.getOrDefault(c, 0) + 1);
        
        int l = dfs(n.left, c, t, m);
        int r = dfs(n.right, c, t, m);
        
        m.put(c, m.get(c) - 1);
        
        return v + l + r;
    }
}