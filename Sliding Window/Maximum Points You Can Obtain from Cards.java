/*
LeetCode: 1423. Maximum Points You Can Obtain from Cards
Link: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

Pattern:
Sliding Window from Ends / Complement Window

Problem Statement:
You are given an array cardPoints and an integer k.
You can pick exactly k cards from either the beginning or the end of the array.
Return the maximum score you can obtain.

Key Insight:
Picking k cards from the ends is equivalent to:
- Taking x cards from the left
- Taking (k - x) cards from the right

Approach:
1. Start by taking all k cards from the left (initial sum)
2. Gradually move one card at a time from the left to the right
3. Track the maximum sum obtained at each step

Why This Works:
- Only k+1 combinations exist (0 to k cards from left)
- Avoids checking all subsets

Time Complexity:
O(k)

Space Complexity:
O(1)

Edge Cases:
- k = 0
- k = array length
- All card points are negative or positive
*/

public class MaximumPointsFromCards {

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        // Sum of first k cards from the left
        int leftSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        int maxSum = leftSum;
        int rightSum = 0;
        int rightIndex = n - 1;

        // Move cards from left to right
        for (int i = k - 1; i >= 0; i--) {
            leftSum -= cardPoints[i];       // remove one card from left
            rightSum += cardPoints[rightIndex]; // add one card from right
            rightIndex--;

            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        return maxSum;
    }
}
