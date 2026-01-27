/*
Problem: Maximum Sum Subarray of Size K(GFG)
Pattern:
Sliding Window (Fixed Size)

Problem Statement:
Given an integer array arr and an integer k,
find the maximum sum of any contiguous subarray of size k.

Approach:
1. Calculate the sum of the first window of size k
2. Store it as maxSum
3. Slide the window across the array:
   - Add the next element entering the window
   - Remove the element leaving the window
4. Update maxSum at each step

Why This Works:
- Sliding window avoids recalculating sums repeatedly
- Each element is added and removed exactly once
- Efficient for fixed-size subarray problems

Time Complexity:
O(n) — each element is processed once

Space Complexity:
O(1) — constant extra space

Edge Cases:
- k equals array length
- Array contains negative numbers
- Array contains both positive and negative values
*/

class Solution {

    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int maxSum = sum;

        for (int i = k; i < n; i++) {
            sum = sum + arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
