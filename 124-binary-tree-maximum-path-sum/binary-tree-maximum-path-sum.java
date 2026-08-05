/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        gainFromSubtree(root);
        return maxSum;
    }

    private int gainFromSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Ignore subtrees with negative path sums
        int leftGain = Math.max(0, gainFromSubtree(root.left));
        int rightGain = Math.max(0, gainFromSubtree(root.right));

        // Price of the full path with 'root' as the highest node/turning point
        int priceNewpath = root.val + leftGain + rightGain;

        // Update global maximum path sum
        maxSum = Math.max(maxSum, priceNewpath);

        // Return the max path sum continuing through one child branch to the parent
        return root.val + Math.max(leftGain, rightGain);
    }
}