package arrays;

/*
=============================================
LeetCode 26 – Remove Duplicates from Sorted Array
=============================================

Problem:
Given a sorted integer array nums, remove the duplicates
in-place such that each unique element appears only once.
The relative order of the elements should be kept the same.

Return the number of unique elements (k).
The first k elements of nums should contain the result.

------------------------------------------------
Approach (Two Pointers):
------------------------------------------------
Since the array is already sorted, duplicates will be
adjacent.

Steps:
1. Use one pointer (slow) to track the position of the
   last unique element
2. Use another pointer (fast) to scan through the array
3. When nums[fast] != nums[slow], increment slow and
   copy nums[fast] to nums[slow]

------------------------------------------------
Why Two Pointers?
------------------------------------------------
- Takes advantage of sorted order
- In-place modification
- No extra space required

------------------------------------------------
Edge Cases Considered:
------------------------------------------------
1. Empty array → return 0
2. Single element → return 1
3. All elements same → return 1
4. No duplicates → return array length
5. Negative numbers → handled correctly

------------------------------------------------
Complexity Analysis:
------------------------------------------------
Time Complexity: O(n)
Space Complexity: O(1)

------------------------------------------------
Interview Takeaway:
------------------------------------------------
For sorted arrays, two-pointer techniques are often
the most optimal way to handle duplicates in-place.

=============================================
*/

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        // Edge case: empty array
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0;

        // fast pointer starts from index 1
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        // Number of unique elements
        return slow + 1;
    }
}
