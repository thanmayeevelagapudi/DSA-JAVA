package hashmap;

/*
=============================================
LeetCode 242 – Valid Anagram
=============================================

Problem:
Given two strings s and t, return true if t is an
anagram of s; otherwise, return false.

An anagram uses the same characters with the same
frequencies, possibly in a different order.

------------------------------------------------
Optimized Approach (Frequency Array):
------------------------------------------------
Since the strings contain only lowercase English
letters ('a' to 'z'), we can use an integer array
of size 26 instead of a HashMap.

Key Idea:
- Increment the count for characters in string s
- Decrement the count for characters in string t
- If both strings are anagrams, all counts must
  return to zero

------------------------------------------------
Why This Works:
------------------------------------------------
- Each character in s is matched with the same
  character in t
- Any mismatch in frequency leaves a non-zero
  count in the array

------------------------------------------------
Edge Cases Considered:
------------------------------------------------
1. Different string lengths → not anagrams
2. Empty strings → valid anagrams
3. Repeating characters → handled correctly
4. Only lowercase letters → safe for int[26]
5. Single-character strings → works correctly

------------------------------------------------
Complexity Analysis:
------------------------------------------------
Time Complexity: O(n)
Space Complexity: O(1)

------------------------------------------------
Interview Takeaway:
------------------------------------------------
Using a fixed-size frequency array avoids hashing
overhead and is the most efficient solution when
character constraints are known.

=============================================
*/

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        // Anagrams must be of equal length
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];       //[0,0,0,0,0...........0,0]

        // Increment for s and decrement for t in one pass
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // If all counts are zero, strings are anagrams
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }
}
