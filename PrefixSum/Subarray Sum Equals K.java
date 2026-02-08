/*
LeetCode: 560. Subarray Sum Equals K
Link: https://leetcode.com/problems/subarray-sum-equals-k/

Pattern:
Prefix Sum + HashMap (Frequency Counting)

Problem Statement:
Given an integer array nums and an integer k,
return the total number of continuous subarrays
whose sum equals k.

Approach:
1. Use a HashMap to store the frequency of prefix sums.
2. Initialize the map with (0 → 1) to handle subarrays
   that start from index 0.
3. Traverse the array while maintaining a running sum.
4. For each element:
   - If (currentSum - k) exists in the map,
     add its frequency to the answer.
   - Update the frequency of currentSum in the map.

Why This Works:
- If prefixSum[j] - prefixSum[i] = k,
  then the subarray (i + 1) to j has sum k.
- The HashMap allows constant-time lookup of
  previously seen prefix sums.

Time Complexity:
O(n) — single pass through the array

Space Complexity:
O(n) — HashMap storing prefix sum frequencies

Edge Cases:
- Negative numbers in array
- k = 0
- Multiple overlapping subarrays
*/

import java.util.HashMap;

class Solution {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }

            prefixSumCount.put(
                currentSum,
                prefixSumCount.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
    }
}
