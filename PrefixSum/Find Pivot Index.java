/*
LeetCode: 724. Find Pivot Index
Link: https://leetcode.com/problems/find-pivot-index/

Pattern:
Prefix Sum / Running Sum

Problem Statement:
Given an integer array nums, return the pivot index.
The pivot index is the index where the sum of all elements
to the left is equal to the sum of all elements to the right.
If no such index exists, return -1.

Approach:
1. Compute the total sum of the array.
2. Initialize leftSum = 0.
3. Traverse the array:
   - For index i, rightSum = totalSum - leftSum - nums[i]
   - If leftSum == rightSum, return i.
   - Update leftSum by adding nums[i].
4. If no pivot index is found, return -1.

Why This Works:
- At each index, we compare the sum of elements on the left
  with the sum of elements on the right in O(1) time.
- Prefix sum avoids recalculating sums repeatedly.

Time Complexity:
O(n) — single pass after computing total sum

Space Complexity:
O(1) — constant extra space

Edge Cases:
- Pivot at index 0
- Pivot at last index
- No pivot index exists
*/

public class PivotIndex {

    public int pivotIndex(int[] nums) {
        int totalSum = 0;

        // Calculate total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        // Traverse to find pivot index
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}
