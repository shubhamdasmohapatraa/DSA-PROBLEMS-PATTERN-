/*
LeetCode: 560. Subarray Sum Equals K
Link: https://leetcode.com/problems/subarray-sum-equals-k/

Pattern:
Arrays + Prefix Sum + HashMap

Problem Statement:
Given an array of integers nums and an integer k,
return the total number of continuous subarrays whose sum equals k.

Approach:
1. Use a prefix sum to store the cumulative sum while traversing the array
2. Use a HashMap to store:
   - key   → prefix sum
   - value → frequency of that prefix sum
3. For each index:
   - If (currentSum - k) exists in the map,
     it means there exists a subarray ending at current index with sum k
4. Add the frequency of (currentSum - k) to the answer
5. Update the frequency of currentSum in the map

Why map.put(0, 1) Is Needed:
- It handles subarrays that start from index 0
- If currentSum == k, then (currentSum - k) == 0

Time Complexity:
O(n) — single traversal of the array

Space Complexity:
O(n) — HashMap storing prefix sums

Edge Cases:
- Negative numbers in array
- k = 0
- Multiple overlapping subarrays
*/

import java.util.HashMap;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Base case: prefix sum 0 occurs once
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            // Check if a subarray with sum k exists
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Update prefix sum frequency
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
