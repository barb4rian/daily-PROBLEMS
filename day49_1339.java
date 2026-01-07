class Solution {
    long maxProd = 0, total = 0;
    
    public int maxProduct(TreeNode root) {
        total = totalSum(root);
        subtreeSum(root);
        return (int)(maxProd % 1000000007);
    }
    
    private long totalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + totalSum(node.left) + totalSum(node.right);
    }
    
    private long subtreeSum(TreeNode node) {
        if (node == null) return 0;
        long left = subtreeSum(node.left);
        long right = subtreeSum(node.right);
        long curr = node.val + left + right;
        maxProd = Math.max(maxProd, curr * (total - curr));
        return curr;
    }
}