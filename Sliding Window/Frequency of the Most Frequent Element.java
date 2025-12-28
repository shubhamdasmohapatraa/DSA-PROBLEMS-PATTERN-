/*
LeetCode 1838 - Frequency of the Most Frequent Element

Pattern:
Sorting + Sliding Window + Prefix Sum

Idea:
Make all elements in a window equal to the rightmost element
using at most k increments.
*/

import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int l = 0;
        long windowSum = 0;
        int maxFreq = 0;

        for (int r = 0; r < nums.length; r++) {
            windowSum += nums[r];

            // cost to make all elements equal to nums[r]
            while ((long)(r - l + 1) * nums[r] - windowSum > k) {
                windowSum -= nums[l];
                l++;
            }

            maxFreq = Math.max(maxFreq, r - l + 1);
        }

        return maxFreq;
    }
}
