class Solution {
    public Node connect(Node root) {
        Node current = root; // Current node in the parent level
        Node dummyHead = new Node(0); // Dummy node to build the next level's linked list
        Node tail = dummyHead; // Tail pointer for the next level's linked list

        while (current != null) {
            while (current != null) {
                // If left child exists, attach to tail and advance tail
                if (current.left != null) {
                    tail.next = current.left;
                    tail = tail.next;
                }

                // If right child exists, attach to tail and advance tail
                if (current.right != null) {
                    tail.next = current.right;
                    tail = tail.next;
                }

                // Move to the next node in the current level
                current = current.next;
            }

            // Move to the first node of the next level
            current = dummyHead.next;

            // Reset dummy head and tail for the subsequent level
            dummyHead.next = null;
            tail = dummyHead;
        }

        return root;
    }
}