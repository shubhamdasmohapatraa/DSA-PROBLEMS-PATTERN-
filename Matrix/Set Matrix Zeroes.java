/*
LeetCode: 73. Set Matrix Zeroes
Link: https://leetcode.com/problems/set-matrix-zeroes/

Pattern:
Arrays / Matrix / In-Place Marking

Problem Statement:
Given an m x n integer matrix, if an element is 0,
set its entire row and column to 0.
The operation must be done in-place.

Approach (In-Place Marker Technique):
1. Use the first row to mark columns that should be zero
2. Use the first column to mark rows that should be zero
3. Track whether the first row and first column originally contain zero
4. Update the matrix based on markers
5. Finally handle first row and first column separately

Why This Works:
- The first row and column act as storage for zero markers
- Avoids using extra space for row/column arrays
- Ensures in-place modification with constant space

Time Complexity:
O(m × n) — single traversal of the matrix

Space Complexity:
O(1) — no extra space used

Edge Cases:
- Zero present in first row
- Zero present in first column
- Single row or single column matrix
*/

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check first row
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check first column
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Mark rows and columns
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set matrix zeroes using markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Handle first row
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Handle first column
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
