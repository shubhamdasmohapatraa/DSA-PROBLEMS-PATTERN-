/*
LeetCode 876 - Middle of the Linked List

Approach:
Fast & Slow Pointer Technique

Slow moves 1 step
Fast moves 2 steps
When fast reaches end, slow is at the middle
*/

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
