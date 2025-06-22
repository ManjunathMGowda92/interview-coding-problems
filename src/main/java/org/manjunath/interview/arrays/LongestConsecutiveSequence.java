package org.manjunath.interview.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    /**
     * Finding the longest consecutive sequence in unordered array.
     * The below method uses sorting technique to sort the array and then
     * compares the previous element with current element to find the numbers in sequence.
     * The time complexity is O(NLogN) and Space complexity is O(1)
     *
     * @param nums Unordered Integer Array
     * @return Longest consecutive sequence number count.
     */
    public int longestConsecutive(int[] nums) {
        // if Array is null or empty then return 0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // If the array contains only one element, then return 1
        if (nums.length == 1) {
            return 1;
        }
        // Sort the Array
        Arrays.sort(nums);

        // Initialize 2 variables to hold longest and current consecutive sequence count.
        int longestSeq = 0;
        int currentSeq = 1;
        for (int i = 1; i < nums.length; i++) {
            // if the previous num and current num difference is zero, then continue (as they are same elements)
            if (nums[i - 1] - nums[i] == 0) {
                continue;
            }

            // If the previous num and current num difference is 1, then increment the currentSeq
            // and continue to next element
            if (nums[i] - nums[i - 1] == 1) {
                currentSeq++;
                continue;
            }

            // Assign the maximum value to longest sequence.
            longestSeq = Math.max(currentSeq, longestSeq);
            currentSeq = 1;
        }

        // return the maximum count between the currentSeq and longestSeq (if the array reached its end,
        // then the longest sequence may not be calculated inside the loop)
        return Math.max(currentSeq, longestSeq);
    }

    /**
     * Method to find the Longest Consecutive Sequence in the input array using the HashSet.
     * HashSet will remove the duplicates and no need to sorting the input array.
     * @param nums Unordered Integer array
     * @return Longest consecutive sequence number count.
     */
    public int longestConsecutiveUsingSet(int[] nums) {
        // If the array is null or empty then return 0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Create a Set to hold the input array values.
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        // Iterate through the Set and find the longest consecutive sequence.
        int longestSeq = 1;
        for (int num : numSet) {
            // If the Set contains the previous number of current number, then continue to next element.
            // As the current number count will be added in the lesser previous number count only
            if (numSet.contains(num - 1)) {
                continue;
            } else {
                // Check if the next sequence numbers of current number exist in the Set
                // by incrementing the currentSequence count
                int currentNum = num;
                int currentSeq = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentSeq++;
                }

                // Assign the maximum value to LongestSequence
                longestSeq = Math.max(longestSeq, currentSeq);
            }
        }
        return longestSeq;
    }
}
