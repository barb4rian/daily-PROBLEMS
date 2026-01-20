class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }
    
    private void dfs(TreeNode node, int depth, List<Integer> result) {
        if (node == null) return;
        
        // If this is the first node at this depth (since we traverse right first)
        if (depth == result.size()) {
            result.add(node.val);
        }
        
        // Traverse right child first (for right side view)
        dfs(node.right, depth + 1, result);
        dfs(node.left, depth + 1, result);
    }
}