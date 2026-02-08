/*
LeetCode: 303. Range Sum Query - Immutable
Link: https://leetcode.com/problems/range-sum-query-immutable/

Pattern:
Prefix Sum / Precomputation

Problem Statement:
Given an integer array nums, handle multiple queries where
each query asks for the sum of elements between indices
left and right (inclusive).

Approach:
1. Precompute the prefix sum array:
   - prefix[i] stores the sum of elements from index 0 to i.
2. To answer a query (left, right):
   - If left == 0 → return prefix[right]
   - Else → return prefix[right] - prefix[left - 1]
3. This allows each query to be answered in O(1) time.

Why Prefix Sum Is Used:
- A brute-force approach recalculates the sum for every query.
- Prefix sums trade a one-time preprocessing cost
  for very fast query responses.

Time Complexity:
- Constructor: O(n)
- Each sumRange query: O(1)

Space Complexity:
O(n) — extra array for prefix sums

Edge Cases:
- left == 0
- left == right
- Single element array
*/

class NumArray {

    private int[] prefix;

    public NumArray(int[] nums) {
        int n = nums.length;
        prefix = new int[n];

        if (n > 0) {
            prefix[0] = nums[0];
            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefix[right];
        }
        return prefix[right] - prefix[left - 1];
    }
}
