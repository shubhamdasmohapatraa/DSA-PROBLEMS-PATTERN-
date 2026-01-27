/*
LeetCode: 1. Two Sum
Link: https://leetcode.com/problems/two-sum/

Pattern:
Hashing / One Pass Lookup

Problem Statement:
Given an array of integers nums and an integer target,
return the indices of the two numbers such that they add up to target.

You may assume that each input has exactly one solution,
and you may not use the same element twice.

Approach:
1. Create a HashMap to store numbers and their indices
2. Traverse the array:
   - For each number nums[i], calculate complement = target - nums[i]
   - If the complement exists in the map, return indices
   - Otherwise, store nums[i] with its index in the map
3. Since exactly one solution exists, return as soon as it is found

Why This Works:
- HashMap allows O(1) average-time lookup
- Each element is processed only once
- Ensures we never reuse the same element

Time Complexity:
O(n) — single pass through the array

Space Complexity:
O(n) — HashMap stores up to n elements

Edge Cases:
- Negative numbers
- Duplicate values
- Target formed by first two elements
*/

import java.util.HashMap;

class Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        // As per problem constraints, this line will never be reached
        return new int[] {};
    }
}
