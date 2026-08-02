import java.util.ArrayList;
import java.util.List;

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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();

        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // Try every number in the range [start, end] as the root
        for (int i = start; i <= end; i++) {
            // Generate all possible left and right subtrees
            List<TreeNode> leftTrees = buildTrees(start, i - 1);
            List<TreeNode> rightTrees = buildTrees(i + 1, end);

            // Connect left and right subtrees to the root 'i'
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currentRoot = new TreeNode(i);
                    currentRoot.left = left;
                    currentRoot.right = right;
                    allTrees.add(currentRoot);
                }
            }
        }

        return allTrees;
    }
}