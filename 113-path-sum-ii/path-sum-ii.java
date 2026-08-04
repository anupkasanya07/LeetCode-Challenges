class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        backtrack(root, targetSum, currentPath, result);
        return result;
    }

    private void backtrack(TreeNode node, int remainingSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        // Add current node to current path
        currentPath.add(node.val);

        // Check if it's a leaf node and sum matches
        if (node.left == null && node.right == null && remainingSum == node.val) {
            result.add(new ArrayList<>(currentPath));
        } else {
            // Recurse down left and right subtrees
            backtrack(node.left, remainingSum - node.val, currentPath, result);
            backtrack(node.right, remainingSum - node.val, currentPath, result);
        }

        // Backtrack: remove last element before returning to parent node
        currentPath.remove(currentPath.size() - 1);
    }
}