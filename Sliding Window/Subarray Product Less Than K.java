/*
LeetCode: 713. Subarray Product Less Than K
Link: https://leetcode.com/problems/subarray-product-less-than-k/

Pattern:
Sliding Window (Variable Size)

Problem Statement:
Given an array of positive integers nums and an integer k,
return the number of contiguous subarrays where the product
of all elements is strictly less than k.

Key Insight:
- Since all numbers are positive, increasing the window
  increases the product monotonically
- This allows a sliding window approach

Approach:
1. Use two pointers (left and right) to maintain a window
2. Multiply the current element into the product
3. While product >= k, shrink the window from the left
4. At each right index, all subarrays ending at right
   and starting from left to right are valid

Why count += (right - left + 1):
- Number of valid subarrays ending at index right
- Covers all possible starting points within the window

Special Case:
- If k <= 1, no subarray can have product < k

Time Complexity:
O(n) — each element enters and leaves the window once

Space Complexity:
O(1) — constant extra space

Edge Cases:
- k <= 1
- Single-element array
- Large values in nums
*/

public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int left = 0;
        int product = 1;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            // Shrink window if product >= k
            while (product >= k) {
                product /= nums[left];
                left++;
            }

            // All subarrays ending at right are valid
            count += right - left + 1;
        }

        return count;
    }
}
