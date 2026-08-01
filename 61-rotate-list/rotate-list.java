/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Base cases: empty list, single node, or zero rotation
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1. Calculate the length and find the tail
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // 2. Normalize k
        k = k % length;
        if (k == 0) {
            return head; // No rotation needed
        }

        // 3. Make the linked list circular
        tail.next = head;

        // 4. Find the new tail: (length - k) steps from the head
        int stepsToNewTail = length - k;
        ListNode newTail = tail;
        while (stepsToNewTail > 0) {
            newTail = newTail.next;
            stepsToNewTail--;
        }

        // 5. Set the new head and break the ring
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}