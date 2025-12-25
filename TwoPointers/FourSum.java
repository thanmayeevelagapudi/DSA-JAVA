package arrays;

/*
=============================================
LeetCode 18 – 4Sum
=============================================

Problem:
Given an array nums of n integers, return all unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

- a, b, c, d are distinct indices
- nums[a] + nums[b] + nums[c] + nums[d] == target

The solution set must not contain duplicate quadruplets.

------------------------------------------------
Approach (Sorting + Two Pointers):
------------------------------------------------
This problem is an extension of 2Sum / 3Sum.

Steps:
1. Sort the array
2. Fix the first element (i)
3. Fix the second element (j)
4. Use two pointers (left, right) to find remaining two elements
5. Skip duplicates at every level to avoid repeated quadruplets

------------------------------------------------
Why Sorting?
------------------------------------------------
- Enables two-pointer technique
- Makes duplicate handling easy
- Reduces time complexity from brute force O(n⁴)

------------------------------------------------
Duplicate Handling:
------------------------------------------------
- Skip same values for i and j
- After finding a valid quadruplet, skip duplicates for
  left and right pointers

------------------------------------------------
Edge Cases Considered:
------------------------------------------------
1. nums length < 4 → return empty list
2. Multiple duplicates → handled via skipping
3. Negative and positive numbers mixed
4. target = 0 or non-zero
5. Large numbers → handled using long to avoid overflow

------------------------------------------------
Complexity Analysis:
------------------------------------------------
Time Complexity: O(n³)
Space Complexity: O(1) (excluding output list)

------------------------------------------------
Interview Takeaway:
------------------------------------------------
This problem tests:
- Multi-level two-pointer usage
- Duplicate elimination
- Careful boundary handling

=============================================
*/

import java.util.*;
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {

            // Skip duplicates for first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicates for second number
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(
                                nums[i], nums[j], nums[left], nums[right]
                        ));

                        left++;
                        right--;

                        // Skip duplicates for third number
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        // Skip duplicates for fourth number
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                    else if (sum < target) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
