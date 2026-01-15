class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafSeq1 = new ArrayList<>();
        List<Integer> leafSeq2 = new ArrayList<>();
        
        collectLeaves(root1, leafSeq1);
        collectLeaves(root2, leafSeq2);
        
        if (leafSeq1.size() != leafSeq2.size()) {
            return false;
        }
        
        for (int i = 0; i < leafSeq1.size(); i++) {
            if (!leafSeq1.get(i).equals(leafSeq2.get(i))) {
                return false;
            }
        }
        
        return true;
    }
    
    private void collectLeaves(TreeNode node, List<Integer> leafList) {
        if (node == null) {
            return;
        }
        
        if (node.left == null && node.right == null) {
            leafList.add(node.val);
            return;
        }
        
        collectLeaves(node.left, leafList);
        collectLeaves(node.right, leafList);
    }
}