/*
LeetCode: 922. Sort Array By Parity II
Link:https: //leetcode.com/problems/sort-array-by-parity-ii/

Pattern:
Two Pointers

Problem Statement:
Given an array nums where half of the integers are even and half are odd,
rearrange the array so that nums[evenIndex] is even and nums[oddIndex] is odd.

Approach:
1. Use two pointers:
   - i for even indices (starts at 0)
   - j for odd indices (starts at 1)
2. Traverse the array:
   - If nums[i] is even, move i by 2
   - If nums[j] is odd, move j by 2
3. If nums[i] is odd and nums[j] is even, swap them
4. Continue until either pointer goes out of bounds

Why It Works:
- Even indices can only accept even numbers
- Odd indices can only accept odd numbers
- Swapping fixes both positions in one operation

Time Complexity:
O(n) — each element is visited at most once

Space Complexity:
O(1) — in-place swapping, no extra space used

Edge Cases:
- Already valid array
- Minimum size array
- Large input size
*/

public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int i = 0; // pointer for even indices
        int j = 1; // pointer for odd indices

        while (i < n && j < n) {
            if (nums[i] % 2 == 0) {
                i += 2;
            } else if (nums[j] % 2 == 1) {
                j += 2;
            } else {
                // swap misplaced even and odd elements
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i += 2;
                j += 2;
            }
        }
        return nums;
    }
}
