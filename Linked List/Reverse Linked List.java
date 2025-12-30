/*
LeetCode 206 - Reverse Linked List

Approach:
Iterative pointer reversal

We maintain three pointers:
- prev: previous node (initially null)
- curr: current node
- next: stores next node temporarily
*/

class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // store next node
            curr.next = prev;          // reverse link
            prev = curr;               // move prev
            curr = next;               // move curr
        }

        return prev; // new head
    }
}
