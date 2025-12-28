/*
LeetCode: 1658. Minimum Operations to Reduce X to Zero

Pattern:
Prefix Sum + HashMap (Longest Subarray)

Key Idea:
Instead of removing elements from both ends,
find the longest subarray with sum = totalSum - x.
*/

import java.util.HashMap;

public class MinimumOperationsToReduceX {

    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int totalSum = 0;
        HashMap<Integer, Integer> prefixIndex = new HashMap<>();

        // Prefix sum base case
        prefixIndex.put(0, -1);

        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            prefixIndex.put(totalSum, i);
        }

        int target = totalSum - x;
        if (target < 0) return -1;

        int prefixSum = 0;
        int longest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];

            int needed = prefixSum - target;
            if (prefixIndex.containsKey(needed)) {
                longest = Math.max(longest, i - prefixIndex.get(needed));
            }
        }

        return longest == Integer.MIN_VALUE ? -1 : n - longest;
    }
}
