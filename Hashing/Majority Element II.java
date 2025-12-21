/*
LeetCode: 229. Majority Element II
Link: https://leetcode.com/problems/majority-element-ii/

Pattern:
Arrays / Hashing

Problem Statement:
Given an integer array nums of size n, return all elements that appear
more than ⌊ n / 3 ⌋ times.
You may return the answer in any order.

Approach (HashMap Frequency Count):
1. Traverse the array and store the frequency of each element in a HashMap
2. Iterate through the map and add elements with frequency > n / 3 to result list
3. Return the result list

Why This Works:
- HashMap provides efficient counting of occurrences
- At most two elements can appear more than n / 3 times
- Simple and easy to implement

Time Complexity:
O(n) — one pass to build the map and one pass to filter results

Space Complexity:
O(n) — extra space for HashMap

Edge Cases:
- Array size less than 3
- All elements same
- No element appears more than n / 3 times
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) > n / 3) {
                result.add(key);
            }
        }

        return result;
    }
}
