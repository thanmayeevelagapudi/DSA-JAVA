// Leetcode: 219 - Contains Duplicate II
// Problem: Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array 
// such that nums[i] == nums[j] and abs(i - j) <= k.
// Approach: Sliding Window with HashSet
// Time Complexity: O(n) - We traverse through the array once.
// Space Complexity: O(k) - We store at most k elements in the hash set.

import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k <= 0) {
            return false;
        }

        HashSet<Integer> window = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // If duplicate element is found within the window size
            if (window.contains(nums[i])) {
                return true;
            }
            
            window.add(nums[i]);
            
            // If the window size exceeds k, remove the element at the leftmost position
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        
        return false;
    }
}

