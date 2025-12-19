/*
LeetCode: 189. Rotate Array
Link: https://leetcode.com/problems/rotate-array/

Pattern:
Arrays / Two Pointers (Reversal Technique)

Problem Statement:
Given an integer array nums, rotate the array to the right by k steps,
where k is non-negative.

Approach (Reversal Algorithm):
1. Normalize k using k = k % n (to handle large k values)
2. Reverse the entire array
3. Reverse the first k elements
4. Reverse the remaining n - k elements

Why This Works:
- Reversing the whole array places elements in reverse order
- Reversing segments restores relative order within rotated parts
- Achieves rotation without extra space

Time Complexity:
O(n) — each element is reversed a constant number of times

Space Complexity:
O(1) — in-place rotation

Edge Cases:
- k greater than array length
- k = 0
- Array of size 1
*/

public class RotateArray {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
