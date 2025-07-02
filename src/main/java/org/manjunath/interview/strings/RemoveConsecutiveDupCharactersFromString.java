package org.manjunath.interview.strings;

import java.util.Objects;

public class RemoveConsecutiveDupCharactersFromString {

    /**
     * Method to remove consecutive duplicate characters from the given input string.
     * we are comparing the char at i-th index with (i+1) th index, and if the character
     * is not matching then adding into StringBuilder object.
     * <code>
     * Time Complexity : O(N) -> as we are iterating through complete string
     * Space Complexity : O(N) -> as we are using extra StringBuilder to storage
     * and is modified in each iteration
     * </code>
     *
     * @param str String object with consecutive duplicate characters.
     * @return String object after removal of consecutive characters.
     */
    public String removeDuplicatesWithLinearApproach(String str) {
        if (Objects.isNull(str) || str.isEmpty()) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                builder.append(str.charAt(i));
            }
        }

        // Add the last character to StringBuilder
        builder.append(str.charAt(str.length() - 1));
        return builder.toString();
    }

    /**
     * Method to remove the consecutive duplicates from the string, by comparing the last
     * added character from the result string builder object.
     * <code>
     * Time Complexity : O(N) -> as we are iterating through complete string
     * Space Complexity : O(N) -> as we are using extra StringBuilder to storage
     * and is modified in each iteration
     * </code>
     *
     * @param str String object with consecutive duplicate characters.
     * @return String object after removal of consecutive characters.
     */
    public String removeDuplicatesWithSlidingWindow(String str) {
        // If string is null or empty, then return null
        if (Objects.isNull(str) || str.isEmpty()) {
            return null;
        }

        // Create a StringBuilder object to store final result
        StringBuilder result = new StringBuilder();

        // Iterate through each Character at the index and match it will last added character from result.
        // if the last added character is not matched with current index character, then add the character,
        // else just increment the index
        int i = 0;
        while (i < str.length()) {
            // If the result is empty, then simply add the first character
            if (result.isEmpty() || (result.charAt(result.length() - 1) != str.charAt(i))) {
                result.append(str.charAt(i));
            }
            i++;
        }
        return result.toString();
    }
}
