/*
LeetCode 141 - Linked List Cycle

Approach:
Floyd's Cycle Detection Algorithm (Fast & Slow Pointer)

- Slow pointer moves 1 step
- Fast pointer moves 2 steps
- If a cycle exists, both pointers will meet
- If fast reaches null, no cycle exists
*/

public class Solution {
    public boolean hasCycle(ListNode head) {

        // Edge case: empty list or single node
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // move 1 step
            fast = fast.next.next;    // move 2 steps

            if (slow == fast) {
                return true;           // cycle detected
            }
        }

        return false;                  // no cycle
    }
}
