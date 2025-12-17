package arrays;

/*
=============================================
LeetCode 238 – Product of Array Except Self
=============================================

Problem:
Given an array nums, return an array result such that
result[i] is the product of all elements except nums[i].

Input : [1,2,3,4]
Output : [24,12,8,6]

Constraints:
- No division allowed
- O(n) time complexity
- O(1) extra space (excluding output array)

Approach:
Use prefix (left) and suffix (right) products.

Key Insight:
Product except self at index i = (product of elements to the left of i) × (product of elements to the right of i)

We compute left products first and store them in the result array,
then multiply right products in reverse order.

Time Complexity: O(n)
Space Complexity: O(1)
=============================================
*/

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Store left products
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct;   //left product array = [1,1,2,6]  (after step 1 result)
            leftProduct = leftProduct * nums[i];  
        }

        // Step 2: Multiply right products
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct;  //result[i] = leftprod * rightprod 
            rightProduct = rightProduct * nums[i];
        }

        return result;
    }
}

/*
Edge Cases:
- Array contains zero
- Array contains negative numbers
- Array size = 1
*/
