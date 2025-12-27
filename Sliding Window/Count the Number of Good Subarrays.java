/*
LeetCode: 2537. Count the Number of Good Subarrays
Link: https://leetcode.com/problems/count-the-number-of-good-subarrays/

Pattern:
Sliding Window (Variable Size) + Frequency HashMap + Pair Counting

Problem Statement:
Given an integer array nums and an integer k,
a subarray is called good if it has at least k pairs (i, j)
such that i < j and nums[i] == nums[j].

Return the number of good subarrays.

Key Insight:
- When a number appears x times in a window,
  it contributes x * (x - 1) / 2 pairs.
- Instead of recalculating pairs every time,
  we incrementally update the pair count.

Approach:
1. Use two pointers (left and right) to define a sliding window
2. Maintain a frequency map of elements in the window
3. When adding nums[right]:
   - It forms new pairs equal to its previous frequency
4. When total pairs >= k:
   - All subarrays extending to the right are valid
5. Shrink the window from the left to find all minimal valid windows

Why res += (n - right):
- If current window is valid,
  extending it to the right keeps it valid

Time Complexity:
O(n) — each element enters and leaves the window once

Space Complexity:
O(n) — HashMap for frequencies

Edge Cases:
- k = 0 (all subarrays are valid)
- All elements are unique
- Large input sizes
*/

import java.util.HashMap;

public class CountGoodSubarrays {

    public long countGood(int[] nums, int k) {
        int n = nums.length;

        long result = 0;
        long pairs = 0;

        HashMap<Integer, Integer> freq = new HashMap<>();

        int left = 0;

        for (int right = 0; right < n; right++) {

            // Adding nums[right] creates new pairs
            pairs += freq.getOrDefault(nums[right], 0);
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            // Shrink window while condition is satisfied
            while (pairs >= k) {
                result += (n - right);

                // Remove nums[left]
                freq.put(nums[left], freq.get(nums[left]) - 1);
                pairs -= freq.get(nums[left]);
                left++;
            }
        }

        return result;
    }
}
