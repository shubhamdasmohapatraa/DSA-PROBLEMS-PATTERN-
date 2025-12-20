/*
LeetCode: 48. Rotate Image
Link: https://leetcode.com/problems/rotate-image/

Pattern:
Matrix / In-Place Transformation

Problem Statement:
You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise) in-place.

Approach:
Step 1: Transpose the matrix
- Convert rows into columns by swapping matrix[i][j] with matrix[j][i]

Step 2: Reverse each row
- This completes the 90° clockwise rotation

Why This Works:
- Transpose aligns elements along the diagonal
- Reversing rows shifts columns into correct rotated positions
- Achieves rotation without using extra space

Time Complexity:
O(n²) — each element is visited a constant number of times

Space Complexity:
O(1) — in-place rotation

Edge Cases:
- n = 1 (single element matrix)
- Already rotated matrix
- Large matrix sizes
*/

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
