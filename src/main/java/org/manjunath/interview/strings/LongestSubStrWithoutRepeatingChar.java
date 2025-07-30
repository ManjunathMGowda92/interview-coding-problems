package org.manjunath.interview.strings;

import java.util.Arrays;

/**
 * Class to find out the length of longest substring without repeating characters.
 * The class uses the sliding window and 2 pointers approach to find the longest
 * substring without repeating the characters.
 */
public class LongestSubStrWithoutRepeatingChar {


    /**
     * Method to find the longest substring without repeating characters.
     *
     * @param str Input String.
     * @return Longest substring length without repeating characters.
     */
    public int subStrWithoutRepeatingChar(String str) {

        // Initialize the pointers left and right for the sliding window.
        int left = 0, right = 0, maxLength = 0;

        // Initialize a constant array to store the index of characters.
        int[] hash = new int[256];

        // Fill the index array with -1
        Arrays.fill(hash, -1);

        // Convert the string to character array and get the length of string to a variable.
        char[] arr = str.toCharArray();
        int length = str.length();
        while (right < length) {

            // Check if the character index is already occurred in the String and index stored
            // is greater than or equal to left pointer, if the index is greater than or equal
            // to left pointer index then the character is repeating. So increment the left
            // pointer to next index of the character index.
            if (hash[arr[right]] != -1) {
                if (hash[arr[right]] >= left) {
                    left = hash[arr[right]] + 1;
                }
            }

            // Find the current substring length using (right-left+1) and store the max length
            int subLength = right - left + 1;
            maxLength = Math.max(subLength, maxLength);

            // update the character index to the current right pointer index and increment right pointer.
            hash[arr[right]] = right;
            right++;
        }

        return maxLength;
    }
}
