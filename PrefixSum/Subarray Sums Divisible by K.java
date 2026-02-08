/*
LeetCode: 974. Subarray Sums Divisible by K
Link: https://leetcode.com/problems/subarray-sums-divisible-by-k/

Pattern:
Prefix Sum + HashMap (Remainder Frequency)

Problem Statement:
Given an integer array nums and an integer k,
return the number of non-empty subarrays whose
sum is divisible by k.

Approach:
1. Maintain a running prefix sum.
2. Compute remainder = prefixSum % k.
   - Convert negative remainder to positive using:
     remainder = (remainder + k) % k
3. Use a HashMap to store the frequency of each remainder.
4. If the same remainder has appeared before,
   the subarray between those indices has a sum divisible by k.
5. Add the frequency of the remainder to the result,
   then update the map.

Why This Works:
- If (prefixSum[j] - prefixSum[i]) % k == 0,
  then prefixSum[j] % k == prefixSum[i] % k.
- Equal remainders indicate a valid subarray.

Time Complexity:
O(n) — single pass through the array

Space Complexity:
O(k) — at most k distinct remainders

Edge Cases:
- Negative numbers in array
- k = 1
- All elements divisible by k
*/

import java.util.HashMap;

class Solution {

    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1);

        int prefixSum = 0;
        int result = 0;

        for (int num : nums) {
            prefixSum += num;

            int remainder = (prefixSum % k + k) % k;

            result += remainderCount.getOrDefault(remainder, 0);
            remainderCount.put(
                remainder,
                remainderCount.getOrDefault(remainder, 0) + 1
            );
        }

        return result;
    }
}
