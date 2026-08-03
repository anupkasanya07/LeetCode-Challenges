class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        // Base case: no elements left to process
        if (left > right) {
            return null;
        }

        // Always pick the middle element as the root to maintain balance
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively construct left and right subtrees
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }
}