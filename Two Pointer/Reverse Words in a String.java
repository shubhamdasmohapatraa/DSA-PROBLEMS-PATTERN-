/*
LeetCode: 151. Reverse Words in a String
Link: https://leetcode.com/problems/reverse-words-in-a-string/

Pattern:
Strings / Two Pass Processing

Problem Statement:
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters.
The returned string should have:
- Only single spaces between words
- No leading or trailing spaces

Approach:
1. Trim the string to remove leading and trailing spaces
2. Split the string using one or more spaces as the delimiter
3. Traverse the array of words from end to start
4. Append each word to a StringBuilder with a single space

Why This Works:
- trim() removes extra spaces at the ends
- split(\" +\") handles multiple spaces between words
- StringBuilder ensures efficient string concatenation

Time Complexity:
O(n) — where n is the length of the string

Space Complexity:
O(n) — extra space used for words array and StringBuilder

Edge Cases:
- Multiple spaces between words
- Leading and trailing spaces
- Single word string
*/

public class ReverseWordsInString {

    public String reverseWords(String s) {

        // Remove leading/trailing spaces and split by one or more spaces
        String[] words = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();

        // Append words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" ");
        }

        return sb.toString();
    }
}
