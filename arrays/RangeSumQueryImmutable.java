package arrays;

/*
=============================================
LeetCode 303 – Range Sum Query (Immutable)
=============================================

Problem:
Given an integer array nums, handle multiple queries of the form:
sumRange(left, right), which returns the sum of elements
from index left to right (inclusive).

Key Constraint:
- The array is IMMUTABLE (does not change after initialization)
- Multiple sum queries must be answered efficiently

------------------------------------------------
Core Idea (Prefix Sum):
------------------------------------------------
Instead of recomputing the sum for every query (O(n)),
we preprocess the array using a prefix sum array.

prefix[i] stores the sum of elements from index 0 to i.

Example:
nums = [1, 2, 3, 4]

prefix = [1, 3, 6, 10]

------------------------------------------------
How sumRange(left, right) Works:
------------------------------------------------
If left == 0:
    sum = prefix[right]

Else:
    sum = prefix[right] - prefix[left - 1]

This gives O(1) time per query.

------------------------------------------------
Why This Works:
------------------------------------------------
- Prefix sum avoids repeated summation
- Preprocessing happens once in constructor
- Each query is answered in constant time

------------------------------------------------
Complexity Analysis:
------------------------------------------------
Preprocessing Time: O(n)
Query Time: O(1)
Space Complexity: O(n)  (prefix sum array)


=============================================
*/

public class RangeSumQueryImmutable {

    private int[] prefix;

    // Constructor: builds prefix sum array
    public RangeSumQueryImmutable(int[] nums) {
        prefix = new int[nums.length];
        if (nums.length == 0) return;

        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
    }

    // Returns sum from index left to right (inclusive)
    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefix[right];
        }
        return prefix[right] - prefix[left - 1];
    }
}
