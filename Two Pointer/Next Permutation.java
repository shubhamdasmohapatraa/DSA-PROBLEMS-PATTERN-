/*
LeetCode: 31. Next Permutation
Link: https://leetcode.com/problems/next-permutation/

Pattern:
Arrays / Two Pointers (Lexicographical Ordering)

Problem Statement:
Given an array of integers nums, rearrange it into the next
lexicographically greater permutation of numbers.
If such arrangement is not possible, rearrange it as the
lowest possible order (sorted in ascending order).
The replacement must be in-place.

Approach:
1. Traverse from right to left to find the first index 'i'
   such that nums[i] < nums[i + 1].
   - This identifies the pivot where the permutation can increase.
2. If such index exists:
   - Find the smallest element greater than nums[i] to the right
   - Swap it with nums[i]
3. Reverse the subarray to the right of index 'i'
   to get the smallest lexicographical order.
4. If no such index exists:
   - The array is in descending order
   - Reverse the entire array to get the lowest permutation

Why This Works:
- The suffix after the pivot is always in descending order
- Swapping with the next greater element and reversing the suffix
  guarantees the next immediate permutation

Time Complexity:
O(n) — single traversal and reversal

Space Complexity:
O(1) — in-place operations only

Edge Cases:
- Array already in highest permutation
- Array of size 1
- Array with duplicate elements
*/

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        // Step 1: find the pivot
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // Step 2: find the next greater element and swap
        if (pivot != -1) {
            for (int j = n - 1; j > pivot; j--) {
                if (nums[j] > nums[pivot]) {
                    swap(nums, pivot, j);
                    break;
                }
            }
        }

        // Step 3: reverse the suffix
        reverse(nums, pivot + 1, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
