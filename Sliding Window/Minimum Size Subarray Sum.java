/*
LeetCode: 209. Minimum Size Subarray Sum
Link: https://leetcode.com/problems/minimum-size-subarray-sum/

Pattern:
Sliding Window (Variable Size)

Problem Statement:
Given an array of positive integers nums and a positive integer target,
return the minimal length of a contiguous subarray
of which the sum is greater than or equal to target.
If there is no such subarray, return 0.

Approach:
1. Use two pointers (low and high) to maintain a sliding window
2. Expand the window by moving high and adding nums[high] to sum
3. When sum >= target:
   - Update the minimum length
   - Shrink the window from the left to find a smaller valid window
4. Continue until the end of the array

Why This Works:
- All numbers are positive, so expanding the window increases sum
- Shrinking the window decreases sum
- Two pointers ensure each element is processed at most twice
- Guarantees optimal minimum window length

Time Complexity:
O(n) — each element is visited at most twice

Space Complexity:
O(1) — constant extra space

Edge Cases:
- No subarray meets the target sum
- Single element ≥ target
- Entire array required to meet target
*/

class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int low = 0, high = 0, sum = 0;
        int res = Integer.MAX_VALUE;

        while (high < nums.length) {
            sum += nums[high];

            while (sum >= target) {
                int len = high - low + 1;
                res = Math.min(res, len);

                sum -= nums[low];
                low++;
            }
            high++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
