package greedy;

/*
=============================================
LeetCode 881 – Boats to Save People
=============================================

Problem:
You are given an array people where people[i] is the weight of the ith person, and an integer limit representing the maximum weight a boat can carry.

Each boat can carry at most two people at the same time, provided their combined weight does not exceed limit.

Return the minimum number of boats needed to carry everyone.

------------------------------------------------
Approach (Greedy + Two Pointers):
------------------------------------------------
1. Sort the array of weights
2. Use two pointers:
   - left → lightest person
   - right → heaviest person
3. Try to pair the lightest and heaviest person:
   - If their combined weight ≤ limit → pair them
   - Otherwise, send the heaviest person alone
4. In both cases, one boat is used

------------------------------------------------
Why Greedy Works:
------------------------------------------------
- The heaviest person is the hardest to place
- Pairing them with the lightest possible person
  gives the best chance to save a boat
- Any other pairing would not reduce the boat count

------------------------------------------------
Edge Cases Considered:
------------------------------------------------
1. Empty array → 0 boats
2. Single person → 1 boat
3. All people have same weight
4. No two people can be paired
5. Everyone can be paired optimally
6. Weights exactly equal to limit

------------------------------------------------
Complexity Analysis:
------------------------------------------------
Time Complexity: O(n log n) due to sorting
Space Complexity: O(1) (excluding sorting space)

------------------------------------------------
Interview Takeaway:
------------------------------------------------
This problem is a classic greedy pattern where sorting
+ two pointers leads to an optimal solution.

=============================================
*/

import java.util.Arrays;

public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {

        // Edge case: no people
        if (people == null || people.length == 0) {
            return 0;
        }

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {

            // Try to pair the lightest and heaviest
            if (people[left] + people[right] <= limit) {
                left++;
            }

            // Heaviest person always boards a boat
            right--;
            boats++;
        }

        return boats;
    }
}

