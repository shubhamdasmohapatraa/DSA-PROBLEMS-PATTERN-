/*
LeetCode: 795. Number of Subarrays with Bounded Maximum
Link: https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/

Pattern:
Sliding Window (Variable Size) + Counting

Problem Statement:
Given an integer array nums and two integers left and right,
return the number of contiguous subarrays where the maximum element
lies in the range [left, right].

Key Insight:
- Any subarray with max > right is invalid
- Any subarray with max < left is incomplete
- Valid subarrays must contain at least one element in [left, right]
  and no element > right

Approach:
1. Use two pointers to represent the sliding window
2. Maintain:
   - i → start of valid window (after last invalid element > right)
   - m → number of valid subarrays ending at current index
3. If nums[j] > right:
   - reset window and count
4. If nums[j] is in [left, right]:
   - update m to all subarrays ending at j
5. Add m to the result at each step

Why This Works:
- Tracks valid subarrays ending at each index efficiently
- Avoids nested loops

Time Complexity:
O(n) — single pass through the array

Space Complexity:
O(1) — constant extra space

Edge Cases:
- All elements < left
- All elements > right
- Single-element array
*/

public class NumberOfSubarraysWithBoundedMaximum {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int start = 0;   // start index after last invalid element
        int validCount = 0; // number of valid subarrays ending at current index
        int result = 0;

        for (int end = 0; end < nums.length; end++) {

            // Reset if element is greater than right
            if (nums[end] > right) {
                start = end + 1;
                validCount = 0;
            }
            // If element is within [left, right], update validCount
            else if (nums[end] >= left) {
                validCount = end - start + 1;
            }

            // Add valid subarrays ending at end
            result += validCount;
        }
        return result;
    }
}
