/*
LeetCode 142 - Linked List Cycle II

Approach:
Floyd's Cycle Detection Algorithm

Steps:
1. Use fast & slow pointers to detect cycle
2. If they meet, move one pointer to head
3. Move both pointers one step at a time
4. The meeting point is the start of the cycle
*/

public class Solution {
    public ListNode detectCycle(ListNode head) {

        // Edge case
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                // Step 2: Find cycle start
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr; // cycle entry point
            }
        }

        return null; // no cycle
    }
}
