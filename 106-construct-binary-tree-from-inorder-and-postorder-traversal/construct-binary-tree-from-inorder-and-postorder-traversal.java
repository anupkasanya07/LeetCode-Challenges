import java.util.HashMap;
import java.util.Map;

class Solution {
    private int postorderIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();

        // Store value -> index mappings for O(1) lookup in inorder array
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(postorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] postorder, int left, int right) {
        // Base case: no elements to construct subtrees
        if (left > right) return null;

        // Pick the current root node from postorder traversal (working backwards)
        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);

        // Find root's position in inorder array
        int rootIndexInInorder = inorderIndexMap.get(rootValue);

        // Build RIGHT subtree first because postorder visits right before root in reverse order
        root.right = arrayToTree(postorder, rootIndexInInorder + 1, right);
        root.left = arrayToTree(postorder, left, rootIndexInInorder - 1);

        return root;
    }
}