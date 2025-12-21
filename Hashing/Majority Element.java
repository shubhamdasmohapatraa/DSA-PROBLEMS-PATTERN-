/*
LeetCode: 169. Majority Element
Link: https://leetcode.com/problems/majority-element/

Pattern:
Arrays / Hashing

Problem Statement:
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊ n / 2 ⌋ times.
You may assume that the majority element always exists in the array.

Approach (HashMap Frequency Count):
1. Traverse the array and store frequency of each element in a HashMap
2. Iterate through the map to find the element whose frequency is greater than n / 2
3. Return that element

Why This Works:
- HashMap allows efficient frequency counting
- Guaranteed existence of a majority element simplifies logic
- Easy to understand and implement

Time Complexity:
O(n) — one pass to build map + one pass to check majority

Space Complexity:
O(n) — extra space for HashMap

Edge Cases:
- Array of size 1
- All elements same
- Negative numbers in array
*/

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int result = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) > n / 2) {
                result = key;
            }
        }

        return result;
    }
}
