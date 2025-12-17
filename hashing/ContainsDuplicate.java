package hashmap;

/*
=============================================
LeetCode 217 – Contains Duplicate
=============================================

Problem:
Given an integer array nums, return true if any value
appears at least twice in the array.
Return false if every element is distinct.

------------------------------------------------
Approach:
------------------------------------------------
Use a HashSet to track elements seen so far.

- While iterating through the array:
  - Try to add the element to the set
  - If add() returns false, the element already exists → duplicate found

------------------------------------------------
Why HashSet?
------------------------------------------------
- HashSet provides O(1) average-time lookup and insertion
- We only care about existence, not frequency or order
- Ideal for detecting duplicates efficiently

------------------------------------------------
Edge Cases Considered:
------------------------------------------------
1. nums is null or empty → no duplicates → return false
2. Array with one element → no duplicates → return false
3. Duplicate appears early → return true immediately
4. Duplicate appears late → still detected correctly
5. nums contains negative numbers → handled correctly

------------------------------------------------
Complexity Analysis:
------------------------------------------------
Time Complexity: O(n)
Space Complexity: O(n)

------------------------------------------------
Interview Takeaway:
------------------------------------------------
This is a classic example of trading space for time:
we use extra space (HashSet) to achieve linear time.

=============================================
*/

import java.util.*;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        // Edge case: null or very small array cannot have duplicates
        if (nums == null || nums.length <= 1) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();

        // If add() returns false, the element already exists
        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }

        return false;
    }
}
