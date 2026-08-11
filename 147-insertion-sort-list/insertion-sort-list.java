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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Dummy node to serve as the start of the sorted list
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 'curr' is the node currently being checked/inserted
        ListNode curr = head.next;
        // 'lastSorted' points to the tail of the sorted section
        ListNode lastSorted = head;

        while (curr != null) {
            // If the current node is already in order relative to the sorted portion
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                // Find the location in the sorted list to insert 'curr'
                ListNode prev = dummy;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }

                // Insert 'curr' between 'prev' and 'prev.next'
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }

            // Move to the next node in the original list
            curr = lastSorted.next;
        }

        return dummy.next;
    }
}