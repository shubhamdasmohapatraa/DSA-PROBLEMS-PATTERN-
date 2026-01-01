/*
LeetCode 32 - Longest Valid Parentheses

Approach:
Two-Pointer Bidirectional Scan (Greedy)

Key Idea:
- A valid parentheses substring has equal '(' and ')'
- Scan left to right to handle extra closing brackets ')'
- Scan right to left to handle extra opening brackets '('

Algorithm:
1. Traverse from left to right:
   - Increment counter for '(' and ')'
   - If both counters are equal, update maximum length
   - If ')' exceeds '(', reset counters
2. Traverse from right to left:
   - Same logic, but reset when '(' exceeds ')'
3. Track the maximum valid length found in both passes

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, max = 0;

        // Left to Right Scan
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                max = Math.max(max, left * 2);
            } else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        // Right to Left Scan
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                max = Math.max(max, left * 2);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return max;
    }
}
