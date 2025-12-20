package strings;

/*
=============================================
LeetCode 680 – Valid Palindrome II
=============================================

Problem:
Given a string s, return true if the string can be a
palindrome after deleting at most one character.
Otherwise, return false.

------------------------------------------------
Approach (Two Pointers + One Deletion Allowed):
------------------------------------------------
1. Use two pointers (left and right)
2. Move inward while characters match
3. On first mismatch:
   - Try skipping the left character OR
   - Try skipping the right character
4. If either option forms a palindrome → return true

------------------------------------------------
Key Insight:
------------------------------------------------
We are allowed to delete only ONE character.
So, at the first mismatch, we only need to check
two possibilities.

------------------------------------------------
Why Two Pointers?
------------------------------------------------
- Efficient single pass
- No extra memory
- Natural fit for palindrome problems

------------------------------------------------
Edge Cases Considered:
------------------------------------------------
1. Empty string → valid palindrome
2. Single character → valid palindrome
3. Already a palindrome → true
4. One removable mismatch → true
5. More than one mismatch → false
6. Mixed characters → handled correctly

------------------------------------------------
Complexity Analysis:
------------------------------------------------
Time Complexity: O(n)
Space Complexity: O(1)

------------------------------------------------
Interview Takeaway:
------------------------------------------------
This problem tests careful pointer control and
handling limited modifications.

=============================================
*/

public class ValidPalindromeII {

    public boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                // Try skipping either left or right character
                return isPalindromeRange(s, left + 1, right) ||
                       isPalindromeRange(s, left, right - 1);
            }

            left++;
            right--;
        }

        return true;
    }

    // Helper method to check palindrome in a substring range
    private boolean isPalindromeRange(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
