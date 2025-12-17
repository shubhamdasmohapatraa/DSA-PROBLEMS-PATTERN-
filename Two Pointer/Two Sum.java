/*
LeetCode: 1. Two Sum
Link: https://leetcode.com/problems/two-sum/

Pattern:
Arrays + Hashing

Problem Statement:
Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.
Each input has exactly one solution, and you may not use the same element twice.

Approach:
1. Use a HashMap to store number → index
2. For each element nums[i]:
   - Compute complement = target - nums[i]
   - If complement exists in map, return indices
3. Otherwise, store nums[i] with its index
4. This ensures one-pass traversal

Why HashMap:
- Allows O(1) average lookup time
- Converts brute-force O(n²) solution to O(n)

Time Complexity:
O(n) — single pass through the array

Space Complexity:
O(n) — HashMap stores up to n elements

Edge Cases:
- Negative numbers
- Zero as target
- Duplicate values in array
*/

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
