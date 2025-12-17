package hashmap;

/*
=============================================
LeetCode 2404 – Most Frequent Even Element
=============================================

Problem:
Given an integer array nums, return the most frequent EVEN element.
If there is a tie, return the SMALLEST even element.
If no even element exists, return -1.

------------------------------------------------
Approach:
------------------------------------------------
1. Iterate through the array
2. Count frequency ONLY for even numbers using HashMap
3. Track:
   - max frequency seen so far
   - smallest even number when frequencies tie
4. Return the result, or -1 if no even number exists

------------------------------------------------
Why HashMap?
------------------------------------------------
- We need frequency counting
- Order does not matter
- HashMap gives O(1) average insert and lookup

------------------------------------------------
Tie-breaking Logic:
------------------------------------------------
If two even numbers have the same frequency:
→ choose the smaller number

------------------------------------------------
Edge Cases Considered:
------------------------------------------------
1. nums is null or empty → return -1
2. No even numbers present → return -1
3. Only one even number → return that number
4. Multiple evens with same frequency → return smallest
5. nums contains negative even numbers → handled correctly
6. Large input size → still O(n)

------------------------------------------------
Complexity Analysis:
------------------------------------------------
Time Complexity: O(n)
Space Complexity: O(n) (only even numbers stored)

=============================================
*/

import java.util.*;

public class MostFrequentEvenElement {

    public int mostFrequentEven(int[] nums) {

        // Edge case: null or empty input
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // Step 1: Count frequency of even numbers
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
        }

        // Edge case: no even numbers found
        if (freqMap.isEmpty()) {
            return -1;
        }

        // Step 2: Find most frequent even (smallest in case of tie)
        // Compare each even number's frequency; update the result when a higher frequency is found. Or
        // If frequencies are equal, choose the smaller even number.

        int maxFreq = 0;
        int result = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (freq > maxFreq || (freq == maxFreq && num < result)) {
                maxFreq = freq;
                result = num;
            }
        }

        return result;
    }
}
