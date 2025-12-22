/*
LeetCode: 1248. Count Number of Nice Subarrays
Link: https://leetcode.com/problems/count-number-of-nice-subarrays/

Pattern:
Prefix Sum + HashMap (Counting Odds)

Problem Statement:
Given an array of integers nums and an integer k,
return the number of continuous subarrays with exactly k odd numbers.

Key Insight:
Instead of tracking sum, track the count of odd numbers seen so far.

Approach:
1. Traverse the array and maintain a running count of odd numbers
2. If currentOddCount - k exists in the map,
   then there are subarrays ending at current index with exactly k odds
3. Use a HashMap to store:
   - key   → number of odds seen
   - value → frequency of that odd count

Why map.put(0, 1) Is Needed:
- Handles subarrays that start from index 0
- When oddCount == k, (oddCount - k) = 0

Time Complexity:
O(n) — single pass through the array

Space Complexity:
O(n) — HashMap stores odd count frequencies

Edge Cases:
- All even numbers
- k = 0
- Array starts with odd numbers
*/

import java.util.HashMap;

public class CountNumberOfNiceSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Base case: zero odd numbers seen once
        map.put(0, 1);

        int oddCount = 0;
        int result = 0;

        for (int num : nums) {
            // Increment odd count if number is odd
            if (num % 2 != 0) {
                oddCount++;
            }

            // Check if subarrays with k odds exist
            if (map.containsKey(oddCount - k)) {
                result += map.get(oddCount - k);
            }

            // Update frequency of odd count
            map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
        }
        return result;
    }
}
