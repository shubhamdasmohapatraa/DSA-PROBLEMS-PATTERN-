/*
LeetCode: 942. DI String Match
Link: https://leetcode.com/problems/di-string-match/

Pattern:
Greedy / Two Pointers

Problem Statement:
Given a string s that consists of only 'I' (increase) and 'D' (decrease),
construct a permutation of numbers from 0 to n such that:
- If s[i] == 'I', then perm[i] < perm[i + 1]
- If s[i] == 'D', then perm[i] > perm[i + 1]

Approach:
1. Initialize two pointers:
   - low = 0
   - high = n
2. Traverse the string:
   - If s[i] == 'I', assign the smallest available number (low)
   - If s[i] == 'D', assign the largest available number (high)
3. Move the corresponding pointer after assignment
4. Assign the last remaining number to the final position

Why This Works:
- Choosing the smallest number for 'I' ensures an increase
- Choosing the largest number for 'D' ensures a decrease
- Greedy selection guarantees a valid permutation

Time Complexity:
O(n) — single pass through the string

Space Complexity:
O(n) — result array of size n + 1

Edge Cases:
- All 'I's
- All 'D's
- Single character string
*/

public class DIStringMatch {

    public int[] diStringMatch(String s) {
        int n = s.length();
        int low = 0, high = n;

        int[] res = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                res[i] = low++;
            } else {
                res[i] = high--;
            }
        }

        // One number will remain, low == high
        res[n] = low;
        return res;
    }
}
