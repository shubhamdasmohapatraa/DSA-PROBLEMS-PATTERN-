/*
LeetCode: 75. Sort Colors
Link: https://leetcode.com/problems/sort-colors/

Pattern:
Two Pointers / Dutch National Flag Algorithm

Problem Statement:
Given an array nums with n objects colored red, white, or blue
(represented by 0, 1, and 2), sort them in-place so that objects
of the same color are adjacent, with the order 0, 1, 2.

Approach (Dutch National Flag):
1. Maintain three pointers:
   - i: boundary for 0s (low)
   - j: current index (mid)
   - k: boundary for 2s (high)
2. Traverse while j <= k:
   - If nums[j] == 0 → swap with i, increment both i and j
   - If nums[j] == 1 → j++
   - If nums[j] == 2 → swap with k, decrement k
3. This partitions the array into:
   [0s | 1s | unknown | 2s]

Why This Works:
- Each element is processed at most once
- Swapping ensures correct placement in a single pass

Time Complexity:
O(n) — single traversal of the array

Space Complexity:
O(1) — in-place sorting

Edge Cases:
- Already sorted array
- All elements same (all 0s / all 1s / all 2s)
- Array of size 1
*/

public class SortColors {

    public void sortColors(int[] nums) {
        int n = nums.length;

        int i = 0;       // boundary for 0s
        int j = 0;       // current pointer
        int k = n - 1;   // boundary for 2s

        while (j <= k) {
            if (nums[j] == 2) {
                swap(nums, j, k);
                k--;
            } else if (nums[j] == 1) {
                j++;
            } else { // nums[j] == 0
                swap(nums, j, i);
                i++;
                j++;
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
