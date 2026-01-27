/*
LeetCode: 242. Valid Anagram
Link: https://leetcode.com/problems/valid-anagram/

Pattern:
Sorting / String Manipulation

Problem Statement:
Given two strings s and t, return true if t is an anagram of s,
and false otherwise.

An anagram is a word or phrase formed by rearranging the letters
of another, using all the original letters exactly once.

Approach:
1. If the lengths of s and t are different, they cannot be anagrams
2. Convert both strings into character arrays
3. Sort both character arrays
4. Compare the sorted arrays for equality

Why This Works:
- Anagrams have the same characters with the same frequencies
- Sorting brings identical characters to the same positions
- If both sorted arrays are equal, the strings are anagrams

Time Complexity:
O(n log n) — sorting both strings

Space Complexity:
O(n) — character arrays for both strings

Edge Cases:
- Strings of different lengths
- Empty strings
- Strings with same characters but different order
*/

import java.util.Arrays;

class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return Arrays.equals(ch1, ch2);
    }
}
