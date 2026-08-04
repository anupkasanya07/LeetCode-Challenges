class Solution {
    public int minDepth(TreeNode root) {
        // Base case: empty tree has depth 0
        if (root == null) {
            return 0;
        }

        // If left subtree is null, recurse on right subtree
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        // If right subtree is null, recurse on left subtree
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        // If both subtrees exist, return the minimum of both depths
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}