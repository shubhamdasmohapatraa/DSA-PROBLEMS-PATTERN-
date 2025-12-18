/*
LeetCode: 15. 3Sum
Link: https://leetcode.com/problems/3sum/

Pattern:
Sorting + Two Pointers

Problem Statement:
Given an integer array nums, return all unique triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, j != k and nums[i] + nums[j] + nums[k] == 0.
The solution set must not contain duplicate triplets.

Approach:
1. Sort the array
2. Fix one element nums[i] using a loop
3. Use two pointers:
   - left = i + 1
   - right = n - 1
4. Move pointers based on the sum:
   - If sum == 0 → add triplet and skip duplicates
   - If sum < 0 → move left pointer
   - If sum > 0 → move right pointer
5. Skip duplicate values of nums[i] to avoid duplicate triplets

Why Sorting Is Needed:
- Enables two-pointer technique
- Makes duplicate removal easy and efficient

Time Complexity:
O(n²) — outer loop + two-pointer traversal

Space Complexity:
O(1) extra space (excluding result list)

Edge Cases:
- Array with fewer than 3 elements
- All positive or all negative numbers
- Duplicate values
*/

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left and right pointers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
