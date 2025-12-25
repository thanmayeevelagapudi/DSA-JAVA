package hashmap;

/*
=============================================
LeetCode 49 – Group Anagrams
=============================================

Problem:
Given an array of strings, group the anagrams together. You can return the answer in any order.

------------------------------------------------
Optimized Approach (Frequency Count as Key):
------------------------------------------------
Since strings contain only lowercase English letters,
we represent each word by its character frequency.

Key Idea:
- Build a frequency array of size 26 for each word
- Convert the frequency array into a unique string key
- Use this key to group all anagrams together

Words with the same frequency distribution will generate the same key and belong to the same group.

------------------------------------------------
Why Not Sort Each String?
------------------------------------------------
Sorting each string takes O(m log m) time.
Using frequency counting takes O(m) time.

This improves overall performance, especially when strings are long.

------------------------------------------------
Edge Cases Considered:
------------------------------------------------
1. Empty input array → return empty list
2. Single string → one group
3. Multiple identical strings → grouped together
4. Strings with no anagrams → separate groups
5. Empty strings → grouped together correctly

------------------------------------------------
Complexity Analysis:
------------------------------------------------
Let:
n = number of strings
m = average length of each string

Time Complexity: O(n × m)
Space Complexity: O(n × m)

=============================================
*/

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
      
        if (strs == null || strs.length == 0) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            // Step 1: Build frequency array for the word
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }

            // Step 2: Convert frequency array to a unique key
            // Example: [1,0,2,...] → "1#0#2#..."
            StringBuilder keyBuilder = new StringBuilder();
            for (int c : count) {
                keyBuilder.append(c).append('#');
            }
            String key = keyBuilder.toString();

            // Step 3: Group strings by the key
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        // Collect all grouped anagrams
        result.addAll(map.values());
        return result;
    }
}
