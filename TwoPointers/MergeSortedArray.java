package arrays;

/*
=============================================
LeetCode 88 – Merge Sorted Array
=============================================

Problem:
You are given two sorted integer arrays nums1 and nums2,
where nums1 has a size of m + n, with the first m elements
being valid and the last n elements set to 0.

Merge nums2 into nums1 so that nums1 becomes a single
sorted array.

------------------------------------------------
Approach (Three Pointers – From the End):
------------------------------------------------
To avoid overwriting elements in nums1, we merge from
the end of the array.

Pointers:
- i → last valid element in nums1 (m - 1)
- j → last element in nums2 (n - 1)
- k → last position in nums1 (m + n - 1)

Steps:
1. Compare nums1[i] and nums2[j]
2. Place the larger element at nums1[k]
3. Move pointers accordingly
4. Copy remaining elements from nums2 (if any)

------------------------------------------------
Why Merge from the End?
------------------------------------------------
- nums1 has extra space at the end
- Merging from front would overwrite data
- Backward merge ensures in-place modification

------------------------------------------------
Edge Cases Considered:
------------------------------------------------
1. nums2 is empty → nums1 remains unchanged
2. nums1 has no valid elements (m = 0)
3. nums2 has elements smaller than all in nums1
4. nums2 has elements larger than all in nums1
5. Duplicate values → handled correctly

------------------------------------------------
Complexity Analysis:
------------------------------------------------
Time Complexity: O(m + n)
Space Complexity: O(1)

------------------------------------------------
Interview Takeaway:
------------------------------------------------
Backward two-pointer merging is the standard in-place
solution when extra space is provided at the end.

=============================================
*/

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;          // Pointer for nums1 valid elements
        int j = n - 1;          // Pointer for nums2
        int k = m + n - 1;      // Pointer for merged position

        // Merge while both arrays have elements
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Copy remaining elements from nums2 (if any)
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
