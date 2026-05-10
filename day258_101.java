class Solution {
    public boolean isSymmetric(TreeNode r) {
        return r == null || c(r.left, r.right);
    }
    
    private boolean c(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        return l.val == r.val && c(l.left, r.right) && c(l.right, r.left);
    }
}