 /*
LeetCode: 2161. Partition Array According to Given Pivot
Link: https://leetcode.com/problems/partition-array-according-to-given-pivot/

Pattern:
Arrays / Counting + Placement (Stable Partition)

Problem Statement:
Given an integer array nums and an integer pivot,
rearrange nums such that:
- All elements less than pivot appear first
- Followed by elements equal to pivot
- Followed by elements greater than pivot
The relative order of elements in each group should be preserved.

Approach:
1. First pass:
   - Count how many elements are less than pivot
   - Count how many elements are equal to pivot
2. These counts define starting indices:
   - less than pivot → index 0
   - equal to pivot → index lessPivot
   - greater than pivot → index lessPivot + equalPivot
3. Second pass:
   - Traverse nums again and place each element
     in its correct position in the result array
4. This ensures stability (relative order preserved)

Why Extra Space Is Used:
- In-place partitioning would break relative order
- Using an auxiliary array allows stable placement

Time Complexity:
O(n) — two passes over the array

Space Complexity:
O(n) — extra array for stable partitioning

Edge Cases:
- All elements less than pivot
- All elements equal to pivot
- Pivot not present in array
*/

public class PivotArray {

    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;

        int lessPivot = 0;
        int equalPivot = 0;

        // First pass: count elements
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                lessPivot++;
            }
            if (nums[i] == pivot) {
                equalPivot++;
            }
        }

        // Starting indices for each section
        int i = 0;                     // < pivot
        int j = lessPivot;             // == pivot
        int k = lessPivot + equalPivot; // > pivot

        int[] result = new int[n];

        // Second pass: place elements in correct order
        for (int num : nums) {
            if (num < pivot) {
                result[i++] = num;
            } else if (num == pivot) {
                result[j++] = num;
            } else {
                result[k++] = num;
            }
        }
        return result;
    }
}
