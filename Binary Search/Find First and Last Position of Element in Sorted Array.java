/*
LeetCode 34 - Find First and Last Position of Element in Sorted Array

Approach:
Binary Search (Lower Bound + Upper Bound)

Key Idea:
- Since the array is sorted, binary search can be used
- Perform two binary searches:
  1. Find the first occurrence of target
  2. Find the last occurrence of target

Algorithm:
1. First Binary Search (Left Bound):
   - Move left when nums[mid] == target
   - Store mid as potential answer
2. Second Binary Search (Right Bound):
   - Move right when nums[mid] == target
   - Store mid as potential answer
3. Return both indices

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;

        int low = 0, high = nums.length - 1;

        // Find first occurrence
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

            if (nums[mid] == target) {
                res[0] = mid;
            }
        }

        low = 0;
        high = nums.length - 1;

        // Find last occurrence
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            if (nums[mid] == target) {
                res[1] = mid;
            }
        }

        return res;
    }
}
