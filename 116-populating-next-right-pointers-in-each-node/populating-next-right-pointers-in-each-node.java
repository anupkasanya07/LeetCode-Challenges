class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node leftmost = root;

        // Traverse level by level
        while (leftmost.left != null) {
            Node current = leftmost;

            while (current != null) {
                // Connection 1: Connect left child -> right child
                current.left.next = current.right;

                // Connection 2: Connect right child -> next subtree's left child (if next exists)
                if (current.next != null) {
                    current.right.next = current.next.left;
                }

                // Move to the next node on the current level
                current = current.next;
            }

            // Move down to the leftmost node of the next level
            leftmost = leftmost.left;
        }

        return root;
    }
}