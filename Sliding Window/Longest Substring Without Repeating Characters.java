/*
LeetCode: 3. Longest Substring Without Repeating Characters
Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

Pattern:
Sliding Window (Variable Size) + HashSet

Problem Statement:
Given a string s, find the length of the longest substring
without repeating characters.

Approach:
1. Use two pointers (start and end) to represent a sliding window
2. Maintain a HashSet to store unique characters in the current window
3. Expand the window by moving the end pointer
4. If a duplicate character is found, shrink the window from the start
   until the duplicate is removed
5. Track the maximum window size during the process

Why This Works:
- Each character is added and removed from the set at most once
- Ensures O(n) time complexity

Time Complexity:
O(n) — each character processed at most twice

Space Complexity:
O(min(n, charset)) — at most 128/256 characters

Edge Cases:
- Empty string
- String with all identical characters
- String with all unique characters
*/

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        int maxLength = 0;

        HashSet<Character> set = new HashSet<>();

        while (end < s.length()) {
            char ch = s.charAt(end);

            // If character not present, expand window
            if (!set.contains(ch)) {
                set.add(ch);
                end++;
                maxLength = Math.max(maxLength, end - start);
            } 
            // If duplicate found, shrink window
            else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return maxLength;
    }
}
