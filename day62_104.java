class Solution {
    public int maxDepth(TreeNode r) {
        if (r == null) return 0;
        int l = maxDepth(r.left);
        int rt = maxDepth(r.right);
        return 1 + Math.max(l, rt);
    }
}  