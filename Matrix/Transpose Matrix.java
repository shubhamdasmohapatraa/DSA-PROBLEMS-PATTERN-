/*
LeetCode: 867. Transpose Matrix
Link: https://leetcode.com/problems/transpose-matrix/

Pattern:
Arrays / Matrix Traversal

Problem Statement:
Given a 2D integer matrix, return the transpose of the matrix.
The transpose of a matrix is obtained by flipping the matrix over
its main diagonal, switching the matrix's row and column indices.

Approach:
1. Let the original matrix be of size m x n
2. Create a new matrix of size n x m
3. Traverse the original matrix
4. Assign transposed[j][i] = matrix[i][j]

Why This Works:
- Transpose swaps rows with columns
- Using a new matrix avoids in-place complexity
- Works for both square and rectangular matrices

Time Complexity:
O(m × n) — each element is visited once

Space Complexity:
O(n × m) — extra matrix is used

Edge Cases:
- Single row matrix
- Single column matrix
- Square matrix
*/

class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] transposed = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }

        return transposed;
    }
}
