class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        
        // Search for the node
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Found
            // Case 1: 
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2:
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: 
            else {
                //  successor
                TreeNode successor = findMin(root.right);
                // Replace 
                root.val = successor.val;
                // Delete 
                root.right = deleteNode(root.right, successor.val);
            }
        }
        return root;
    }
    
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}