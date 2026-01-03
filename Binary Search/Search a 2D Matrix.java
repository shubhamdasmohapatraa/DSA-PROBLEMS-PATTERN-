/*
LeetCode 74 - Search a 2D Matrix

Approach:
Binary Search on Flattened Matrix

Key Idea:
- The matrix rows are sorted
- The first element of each row is greater than the last element of the previous row
- This allows treating the 2D matrix as a sorted 1D array

Index Mapping:
- Row index = mid / number_of_columns
- Column index = mid % number_of_columns

Algorithm:
1. Treat the matrix as a virtual 1D sorted array
2. Perform binary search from index 0 to (m * n - 1)
3. Convert mid index to 2D coordinates using division and modulo
4. Compare matrix value with target and adjust search range

Time Complexity: O(log(m * n))
Space Complexity: O(1)
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int midValue = matrix[mid / n][mid % n];

            if (midValue < target) {
                start = mid + 1;
            } else if (midValue > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
