package hashmap;

/*
=============================================
LeetCode 347 – Top K Frequent Elements
=============================================

Problem:
Given an integer array nums and an integer k,
return the k most frequent elements.

Constraints:
- Result can be in any order
- Must be faster than O(n log n)

------------------------------------------------
Approach Overview:
------------------------------------------------
1. Count frequency of each number using a HashMap
2. Group numbers by frequency using Bucket Sort
3. Traverse buckets from highest frequency to lowest
   and collect k elements

Why Bucket Sort?
- Frequency range is from 1 to n
- Avoids sorting → better than O(n log n)

------------------------------------------------
Step-by-Step Explanation:
------------------------------------------------

Example:
nums = [1,1,1,2,2,3], k = 2

Step 1: Frequency Map
--------------------
1 → 3
2 → 2
3 → 1

Step 2: Buckets (index = frequency)
-----------------------------------
Index:   0  1     2     3
Bucket:  - [3]   [2]   [1]

Step 3: Collect from highest frequency
--------------------------------------
Start from end:
bucket[3] → 1
bucket[2] → 2

Result = [1, 2]

------------------------------------------------
Why This Works:
------------------------------------------------
- HashMap gives O(1) average insert/lookup
- Buckets eliminate sorting
- Traversing buckets ensures top frequencies

------------------------------------------------
Complexity Analysis:
------------------------------------------------
Time Complexity: O(n)
- Counting: O(n)
- Bucketing: O(n)
- Collecting: O(n)

Space Complexity: O(n)
- HashMap + bucket array

------------------------------------------------
Interview Takeaway:
------------------------------------------------
Bucket sort is ideal when:
- Keys have bounded frequency
- We want top-k without full sorting

=============================================
*/

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        // Edge case: no elements requested or empty input
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }

        // Step 1: Frequency count
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Bucket sort based on frequency
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        // Step 3: Collect top k frequent elements
        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;
                    if (index == k) break;
                }
            }
        }

        return result;
    }
}
/*
------------------------------------------------
Edge Cases Considered:
------------------------------------------------
1. nums is empty
   - Frequency map will be empty
   - Result is an empty array
2. k == 0
   - No elements requested
   - Return empty array immediately

3. k == number of unique elements
   - All unique elements will be returned

4. All elements have the same frequency
   - Any k elements are valid as per problem statement

5. nums contains negative numbers
   - HashMap supports negative keys without issue

6. nums contains only one element
   - That element is returned if k == 1 */
