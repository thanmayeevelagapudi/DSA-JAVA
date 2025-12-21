package strings;

/*
=============================================
LeetCode 1768 – Merge Strings Alternately
=============================================

Problem:
You are given two strings word1 and word2.
Merge the strings by adding letters in alternating order,
starting with word1. If one string is longer than the other,
append the remaining letters to the end.

------------------------------------------------
Approach (Two Pointers):
------------------------------------------------
1. Use two pointers i and j for word1 and word2
2. Append characters alternately while both strings have characters
3. Append remaining characters from the longer string

------------------------------------------------
Why Two Pointers?
------------------------------------------------
- Simple index-based traversal
- Efficient and easy to reason about
- Avoids unnecessary complexity

------------------------------------------------
Edge Cases Considered:
------------------------------------------------
1. Both strings empty → return empty string
2. One string empty → return the other string
3. Strings of equal length
4. One string longer than the other
5. Single-character strings

------------------------------------------------
Complexity Analysis:
------------------------------------------------
Time Complexity: O(n + m)
Space Complexity: O(n + m)

(where n and m are lengths of word1 and word2)

------------------------------------------------
Interview Takeaway:
------------------------------------------------
This is a straightforward string manipulation problem
that tests pointer control and edge-case handling.

=============================================
*/

public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {

        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 0;

        // Merge alternately while both strings have characters
        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }

        // Append remaining characters from word1
        while (i < word1.length()) {
            sb.append(word1.charAt(i++));
        }

        // Append remaining characters from word2
        while (j < word2.length()) {
            sb.append(word2.charAt(j++));
        }

        return sb.toString();
    }
}
