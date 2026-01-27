/*
LeetCode: 217. Contains Duplicate
Link: https://leetcode.com/problems/contains-duplicate/

Pattern:
Hashing / Set

Problem Statement:
Given an integer array nums, return true if any value appears
at least twice in the array, and return false if every element
is distinct.

Approach:
1. Create a HashSet to store elements seen so far
2. Traverse the array:
   - If the current element already exists in the set,
     a duplicate is found → return true
   - Otherwise, add the element to the set
3. If the loop completes without finding duplicates,
   return false

Why This Works:
- HashSet stores only unique values
- Lookup and insertion operations are O(1) on average
- As soon as a duplicate appears, we terminate early

Time Complexity:
O(n) — single pass through the array

Space Complexity:
O(n) — extra space used by HashSet

Edge Cases:
- Empty array
- Array with one element
- All elements are unique
- Multiple duplicates present
*/

import java.util.HashSet;

class Solution {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true; // Duplicate found
            }
            set.add(num);
        }

        return false; // No duplicates
    }
}
