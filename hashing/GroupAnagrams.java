package hashmap;

/*
=============================================
LeetCode 49 – Group Anagrams
=============================================

Problem:
Given an array of strings strs, group the anagrams together.
You can return the answer in any order.

An anagram is formed by rearranging the characters of a string
using the same character frequencies.

------------------------------------------------
Approach (Frequency-Count Hashing):
------------------------------------------------
Instead of sorting each string, we represent every string
by a frequency-based key.

Steps:
1. For each string, count occurrences of characters ('a'–'z')
2. Build a unique key using these frequencies
3. Use the key in a HashMap to group anagrams

------------------------------------------------
Why Not Sorting?
------------------------------------------------
Sorting each string costs O(k log k), where k is string length.
Using frequency counting costs O(k) and avoids sorting overhead.

This is more efficient when:
- Character set size is fixed (26 lowercase letters)

------------------------------------------------
Key Insight:
------------------------------------------------
Two strings are anagrams if and only if their character
frequency distributions are identical.

------------------------------------------------
Edge Cases Considered:
------------------------------------------------
1. Empty input array → return empty list
2. Single string → one group
3. Duplicate strings → grouped together
4. Empty strings → grouped correctly
5. Strings with same letters in different order
6. Only lowercase English letters assumed

------------------------------------------------
Complexity Analysis:
------------------------------------------------
Let n = number of strings
Let k = average length of each string

Time Complexity: O(n * k)
Space Complexity: O(n * k)

------------------------------------------------
Interview Takeaway:
------------------------------------------------
Frequency-based hashing is preferred over sorting
when constraints allow, as it improves efficiency.

=============================================
*/

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        // Edge case: empty input
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String key = getFrequencyString(s);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    // Builds a frequency-based key for a string
    private String getFrequencyString(String str) {

        int[] freq = new int[26];

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            sb.append((char) ('a' + i));
            sb.append(freq[i]);
        }

        return sb.toString();
    }
}
