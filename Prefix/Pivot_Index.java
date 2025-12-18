package arrays;

/*
=============================================
LeetCode 724 – Find Pivot Index
=============================================

Problem:
Given an integer array nums, return the pivot index.
The pivot index is the index where the sum of all
elements strictly to the left equals the sum of all
elements strictly to the right.

If no such index exists, return -1.
If multiple pivot indexes exist, return the leftmost one.

------------------------------------------------
Approach (Prefix Sum Optimization):
------------------------------------------------
Instead of recalculating left and right sums for every
index (O(n²)), we use a running prefix sum.

Steps:
1. Compute the total sum of the array
2. Initialize leftSum = 0
3. Iterate through the array:
   - rightSum = totalSum - leftSum - nums[i]
   - If leftSum == rightSum → pivot found
   - Update leftSum by adding nums[i]

------------------------------------------------
Why This Works:
------------------------------------------------
At index i:
Left Sum  = sum of elements before i
Right Sum = totalSum - leftSum - nums[i]

We check equality in O(1) time per index.

------------------------------------------------
Edge Cases Considered:
------------------------------------------------
1. Empty array → return -1
2. Single element → pivot index is 0
3. Pivot at index 0 → left sum = 0
4. Pivot at last index → right sum = 0
5. Negative numbers → handled correctly
6. Multiple pivots → return leftmost

------------------------------------------------
Complexity Analysis:
------------------------------------------------
Time Complexity: O(n)
Space Complexity: O(1)

------------------------------------------------
Interview Takeaway:
------------------------------------------------
This problem demonstrates prefix sum usage to
convert a quadratic solution into linear time.

=============================================
*/

public class PivotIndex {

    public int pivotIndex(int[] nums) {

        // Edge case: empty array
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // Step 1: Calculate total sum
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: Traverse and find pivot
        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}

