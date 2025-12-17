package hashmap;

/*
=============================================
LeetCode 347 – Top K Frequent Elements
=============================================

Problem:
Given an integer array nums and an integer k,
return the k most frequent elements.

------------------------------------------------
Approach Overview:
------------------------------------------------
1. Count the frequency of each element using a HashMap
2. Track the maximum frequency (maxFreq) while counting
3. Create buckets only up to maxFreq (space optimization)
4. Traverse buckets from highest frequency to lowest
   and collect k elements
------------------------------------------------
Why Bucket sort? 
We use bucket sort because the frequency of elements is bounded by the array size. 
Instead of sorting elements by frequency, we group them into buckets where each index represents a frequency. 
This allows us to collect the top-k frequent elements in linear time without performing a full sort.
------------------------------------------------
Edge Cases Considered:
------------------------------------------------
1. nums is null or empty → return empty array
2. k == 0 → return empty array
3. k >= number of unique elements → return all unique elements
4. All elements have same frequency → any k elements are valid
5. nums contains negative numbers → HashMap handles them
6. nums contains only one element → return that element if k == 1

------------------------------------------------
Complexity Analysis:
------------------------------------------------
Time Complexity: O(n)
Space Complexity: O(n)
=============================================
*/

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        // Edge case handling
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }

        // Step 1: Frequency count
        
        Map<Integer, Integer> map = new HashMap<>();
        for( int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
       
       //Track the max Frequency 
        int maxFreq=0;
        for(int freq : map.values()){
            if(freq>maxFreq){
                maxFreq=freq;
            }
        }

        // Step 2: Create buckets only up to maxFreq
        List<Integer>[] buckets = new ArrayList[maxFreq + 1];

       //Initialize each bucket with a array list to store the elements of array
       for (int i=0; i<buckets.length; i++) {
                buckets[i] = new ArrayList<>();
        }

       //Fill the buckets with keys(elements of array)
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
           int element= e.getKey();
           int freqeuncy = e.getValue();
           buckets[freqeuncy].add(element);
        }

        // Step 3: Collect top k frequent elements
      
        int[] result = new int[k];
        int index = 0;

        for (int i = maxFreq; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;
                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}
