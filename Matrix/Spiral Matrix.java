/*
LeetCode: 54. Spiral Matrix
Link: https://leetcode.com/problems/spiral-matrix/

Pattern:
Matrix / Boundary Traversal

Problem Statement:
Given an m x n matrix, return all elements of the matrix in spiral order.

Approach (Boundary Shrinking Technique):
1. Maintain four boundaries:
   - rowBegin (top)
   - rowEnd (bottom)
   - colBegin (left)
   - colEnd (right)
2. Traverse:
   - Left → Right (top row)
   - Top → Bottom (right column)
   - Right → Left (bottom row)
   - Bottom → Top (left column)
3. After each traversal, shrink the corresponding boundary
4. Continue until all elements are visited

Why This Works:
- Boundaries ensure each layer is processed once
- Prevents revisiting elements
- Works for both square and rectangular matrices

Time Complexity:
O(m × n) — every element is visited exactly once

Space Complexity:
O(1) — excluding output list

Edge Cases:
- Empty matrix
- Single row matrix
- Single column matrix
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {

            // Traverse right
            for (int i = colBegin; i <= colEnd; i++) {
                list.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            // Traverse down
            for (int i = rowBegin; i <= rowEnd; i++) {
                list.add(matrix[i][colEnd]);
            }
            colEnd--;

            // Traverse left
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    list.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }

            // Traverse up
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    list.add(matrix[i][colBegin]);
                }
                colBegin++;
            }
        }

        return list;
    }
}
