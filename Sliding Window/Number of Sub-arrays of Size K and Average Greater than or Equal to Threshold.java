/*
LeetCode: 1343. Number of Sub-arrays of Size K and Average >= Threshold
Link: https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/

Pattern:
Sliding Window (Fixed Size)

Problem Statement:
Given an integer array arr, an integer k, and an integer threshold,
return the number of subarrays of size k whose average is greater than
or equal to threshold.

Key Observation:
Average >= threshold  ⇔  sum >= threshold * k

Approach:
1. Compute the sum of the first k elements
2. Check if the average condition is satisfied
3. Slide the window by:
   - Removing the element leaving the window
   - Adding the new element entering the window
4. Update the count whenever the condition is met

Why Sliding Window:
- Brute force would be O(n * k)
- Sliding window reduces it to O(n)

Time Complexity:
O(n) — single pass through the array

Space Complexity:
O(1) — constant extra space

Edge Cases:
- k equals array length
- All elements satisfy / don’t satisfy the condition
- Negative numbers in array
*/

public class NumberOfSubarraysWithAverageAtLeastThreshold {

    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int sum = 0;
        int count = 0;

        // Sum of first window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        if (sum >= threshold * k) {
            count++;
        }

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            sum -= arr[i - k]; // remove left element
            sum += arr[i];     // add right element

            if (sum >= threshold * k) {
                count++;
            }
        }

        return count;
    }
}
