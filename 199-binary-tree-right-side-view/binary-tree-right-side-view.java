import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int depth, List<Integer> result) {
        if (node == null) {
            return;
        }

        // If visiting this depth for the first time, add the rightmost node's value
        if (depth == result.size()) {
            result.add(node.val);
        }

        // Prioritize right branch before left branch
        dfs(node.right, depth + 1, result);
        dfs(node.left, depth + 1, result);
    }
}