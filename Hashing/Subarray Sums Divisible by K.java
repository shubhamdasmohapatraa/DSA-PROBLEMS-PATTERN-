/*
LeetCode: 974. Subarray Sums Divisible by K
Link: https://leetcode.com/problems/subarray-sums-divisible-by-k/

Pattern:
Arrays + Prefix Sum + HashMap + Modulo Arithmetic

Problem Statement:
Given an integer array nums and an integer k,
return the number of non-empty subarrays whose sum is divisible by k.

Approach:
1. Use a prefix sum while traversing the array
2. Compute remainder = prefixSum % k
3. If two prefix sums have the same remainder,
   their difference (subarray sum) is divisible by k
4. Use a HashMap to store frequency of each remainder
5. Handle negative remainders by converting them to positive

Why map.put(0, 1) Is Needed:
- Handles subarrays starting from index 0
- If prefixSum % k == 0, it forms a valid subarray

Handling Negative Numbers:
- Java % can produce negative remainders
- Adjust remainder by adding k if remainder < 0

Time Complexity:
O(n) — single pass through the array

Space Complexity:
O(k) — HashMap stores at most k remainders

Edge Cases:
- Negative numbers in array
- k = 1
- Large input size
*/

import java.util.HashMap;

public class SubarraysDivisibleByK {

    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Base case: remainder 0 has occurred once
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            int remainder = sum % k;
            if (remainder < 0) {
                remainder += k;
            }

            // If same remainder seen before, valid subarrays exist
            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }

            // Update remainder frequency
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }
}
