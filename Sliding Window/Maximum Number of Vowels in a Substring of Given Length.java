/*
LeetCode: 1456. Maximum Number of Vowels in a Substring of Given Length
Link: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

Pattern:
Sliding Window (Fixed Size)

Problem Statement:
Given a string s and an integer k, return the maximum number of vowel letters
in any substring of s with length k.

Approach:
1. Use a fixed-size sliding window of length k
2. Maintain a running count of vowels inside the window
3. Expand the window by moving the right pointer (j)
4. Shrink the window by moving the left pointer (i) when size becomes k
5. Update the maximum vowel count at each valid window

Why Sliding Window:
- Brute force would be O(n * k)
- Sliding window optimizes it to O(n)

Time Complexity:
O(n) — single pass through the string

Space Complexity:
O(1) — constant extra space

Edge Cases:
- String with no vowels
- k equals string length
- All characters are vowels
*/

public class MaximumVowelsInSubstring {

    public int maxVowels(String s, int k) {
        char[] ch = s.toLowerCase().toCharArray();

        int i = 0, j = 0;
        int count = 0;
        int maxVowels = 0;

        while (j < ch.length) {

            // Add current character if it is a vowel
            if (isVowel(ch[j])) {
                count++;
            }

            // When window size reaches k
            if (j - i + 1 == k) {
                maxVowels = Math.max(maxVowels, count);

                // Remove left character if it is a vowel
                if (isVowel(ch[i])) {
                    count--;
                }
                i++; // Slide window forward
            }

            j++;
        }

        return maxVowels;
    }

    // Helper function to check vowel
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
