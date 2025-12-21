/*
LeetCode: 49. Group Anagrams
Link: https://leetcode.com/problems/group-anagrams/

Pattern:
Strings / Hashing / Sorting

Problem Statement:
Given an array of strings strs, group the anagrams together.
You can return the answer in any order.

Approach (Sorting + HashMap):
1. Iterate through each string in the array
2. Convert the string to a character array and sort it
3. Use the sorted string as the HashMap key
4. Add the original string to the list mapped by that key
5. Return all grouped values from the map

Why This Works:
- Anagrams have the same characters in different order
- Sorting normalizes all anagrams to the same key
- HashMap efficiently groups related strings

Time Complexity:
O(n × k log k)
- n = number of strings
- k = maximum length of a string

Space Complexity:
O(n × k)
- HashMap storage for grouped strings

Edge Cases:
- Empty input array
- Strings with different lengths
- Single string input
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
