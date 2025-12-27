package arrays;
 
/*

=============================================

LeetCode 189 – Rotate Array

=============================================
 
Problem:

Given an integer array nums, rotate the array to the right

by k steps, where k is non-negative.
 
------------------------------------------------

Approach (Reversal Algorithm):

------------------------------------------------

We use the array reversal technique to rotate in-place.
 
Steps:

1. Normalize k using k = k % nums.length

2. Reverse the entire array

3. Reverse the first k elements

4. Reverse the remaining n - k elements
 
------------------------------------------------

Why Reversal Works:

------------------------------------------------

Reversing the entire array places the last k elements

at the front, but in reverse order.

Reversing subarrays restores the correct order.
 
------------------------------------------------

Edge Cases Considered:

------------------------------------------------

1. nums is null or empty → no change

2. k = 0 → no rotation

3. k > nums.length → handled using modulo

4. nums length = 1 → no change

5. Negative numbers → handled normally
 
------------------------------------------------

Complexity Analysis:

------------------------------------------------

Time Complexity: O(n)

Space Complexity: O(1)
 
------------------------------------------------

Interview Takeaway:

------------------------------------------------

Reversal algorithm is the optimal in-place solution

for array rotation problems.
 
=============================================

*/
 
public class RotateArray {
 
    public void rotate(int[] nums, int k) {
 
        // Edge case: empty or single-element array

        if (nums == null || nums.length <= 1) {

            return;

        }
 
        int n = nums.length;

        k = k % n;
 
        // Reverse entire array

        reverse(nums, 0, n - 1);
 
        // Reverse first k elements

        reverse(nums, 0, k - 1);
 
        // Reverse remaining elements

        reverse(nums, k, n - 1);

    }
 
    // Helper method to reverse elements between two indices

    private void reverse(int[] nums, int left, int right) {
 
        while (left < right) {

            int temp = nums[left];

            nums[left] = nums[right];

            nums[right] = temp;

            left++;

            right--;

        }

    }

}

 
