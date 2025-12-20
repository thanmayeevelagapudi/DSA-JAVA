package strings;

/*
=============================================
LeetCode 344 – Reverse String
=============================================

Problem:
Write a function that reverses a string.
The input string is given as an array of characters char[] s.
You must do this by modifying the input array in-place
with O(1) extra memory.

------------------------------------------------
Approach (Two-Pointer Technique):
------------------------------------------------
Use two pointers:
- One starting from the beginning (left)
- One starting from the end (right)

Swap characters at left and right positions,
then move pointers towards the center.

------------------------------------------------
Why Two Pointers?
------------------------------------------------
- Reverses the array in-place
- No extra memory required
- Simple and efficient

------------------------------------------------
Edge Cases Considered:
------------------------------------------------
1. Empty array → no change
2. Single character → no change
3. Even length string
4. Odd length string
5. Already reversed string

------------------------------------------------
Complexity Analysis:
------------------------------------------------
Time Complexity: O(n)
Space Complexity: O(1)

------------------------------------------------
Interview Takeaway:
------------------------------------------------
Two-pointer technique is ideal for in-place array
manipulation problems.

=============================================
*/

public class ReverseString {

    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
