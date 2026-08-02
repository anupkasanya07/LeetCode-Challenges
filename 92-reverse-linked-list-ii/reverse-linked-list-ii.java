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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        // Step 1: Reach node at position (left - 1)
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // Step 2: Reverse sublist between left and right in-place
        ListNode curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode subNext = curr.next;
            curr.next = subNext.next;
            subNext.next = prev.next;
            prev.next = subNext;
        }

        return dummy.next;
    }
}