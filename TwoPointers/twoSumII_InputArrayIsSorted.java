package arrays;

/*
=============================================
LeetCode 167 – Two Sum II (Input Array Is Sorted)
=============================================

Problem:
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target.

Return the indices of the two numbers (1-indexed).
Exactly one solution exists.

------------------------------------------------
Approach (Two-Pointer Technique):
------------------------------------------------
Since the array is sorted, we can use two pointers:

1. Initialize:
   - left pointer at the start
   - right pointer at the end
2. Calculate sum = numbers[left] + numbers[right]
3. If sum == target → return indices
4. If sum < target → move left pointer right
5. If sum > target → move right pointer left

------------------------------------------------
Why Two Pointers?
------------------------------------------------
- Sorted order allows directional movement
- Eliminates need for HashMap
- Achieves optimal O(n) time

------------------------------------------------
Edge Cases Considered:
------------------------------------------------
1. Array length = 2 → only one possible pair
2. Target formed by first and last elements
3. Negative numbers included → handled correctly
4. Duplicate values → allowed
5. Exactly one valid solution guaranteed

------------------------------------------------
Complexity Analysis:
------------------------------------------------
Time Complexity: O(n)
Space Complexity: O(1)

------------------------------------------------
Interview Takeaway:
------------------------------------------------
When input is sorted, two-pointer approach is preferred
over hashing for better space efficiency.

=============================================
*/

public class TwoSumII_InputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // Return 1-based indices
                return new int[] { left + 1, right + 1 };
            } 
            else if (sum < target) {
                left++;
            } 
            else {
                right--;
            }
        }

        // As per problem, exactly one solution exists
        return new int[] {};
    }
}
