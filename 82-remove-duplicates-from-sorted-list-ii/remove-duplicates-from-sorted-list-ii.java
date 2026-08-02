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
    public ListNode deleteDuplicates(ListNode head) {
        // Sentinel/Dummy node to simplify head deletions
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        
        while (head != null) {
            // Check if current node is start of duplicate sequence
            if (head.next != null && head.val == head.next.val) {
                // Move head to the last node of the duplicate sequence
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Skip all duplicate nodes
                prev.next = head.next;
            } else {
                // No duplicate found, advance prev pointer
                prev = prev.next;
            }
            
            head = head.next;
        }
        
        return dummy.next;
    }
}