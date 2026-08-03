import java.util.HashMap;
import java.util.Map;

class Solution {
    private int preorderIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();

        // Store value -> index mappings for O(1) lookup in inorder array
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // Base case: no elements to construct subtrees
        if (left > right) return null;

        // Pick the current root node from preorder traversal
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Build left and right subtrees split by the root's index in inorder array
        int rootIndexInInorder = inorderIndexMap.get(rootValue);

        root.left = arrayToTree(preorder, left, rootIndexInInorder - 1);
        root.right = arrayToTree(preorder, rootIndexInInorder + 1, right);

        return root;
    }
}