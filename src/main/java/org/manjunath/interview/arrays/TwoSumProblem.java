package org.manjunath.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {

    /**
     * Method to get the target value with 2 numbers from the given input array.
     *
     * @param arr Input array with integers
     * @param target Target sum value of 2 integers from array.
     * @return indices of 2 numbers which results in target sum.
     */
    public int[] getTwoSum(int[] arr, int target) {
        // Create the HashMap to store each array value with its respective index.
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the Array
        for (int i = 0; i < arr.length; i++) {
            // Find the complement for the current array value.
            int complement = target - arr[i];

            // Check if the complement value exist in the Map as key.
            if (map.containsKey(complement)) {
                // If the complement value found then return current and complement indices.
                return new int[]{i, map.get(complement)};
            }

            // If the complement not found, then store the current array value with
            // respective index for future use.
            map.put(arr[i], i);
        }

        return new int[]{};
    }

    /**
     * This is the brute force method to get the (i,j)th index from array for target sum.
     * But this will yield to time complexity of O(n^2)
     *
     * @param arr    Input array
     * @param target the target sum value
     * @return indices of 2 numbers which results in target sum.
     */
    public int[] getTwoSumBruteForce(int[] arr, int target) {
        // Iterate the array from 0 to length of array, match each i-th index value with
        // j-th index to get target sum, if the ith and jth index sums-up to target then
        // return their index.
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }
}
