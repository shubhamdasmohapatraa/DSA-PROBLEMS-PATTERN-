/*
LeetCode 25 - Reverse Nodes in k-Group

Approach:
- Check if k nodes exist
- Recursively reverse remaining list
- Reverse current k nodes
*/

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        // Check if k nodes exist
        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null) return head;
            temp = temp.next;
        }

        // Reverse remaining list
        ListNode prevNode = reverseKGroup(temp, k);

        // Reverse current k nodes
        temp = head;
        for (int i = 0; i < k; i++) {
            ListNode next = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = next;
        }

        return prevNode;
    }
}
