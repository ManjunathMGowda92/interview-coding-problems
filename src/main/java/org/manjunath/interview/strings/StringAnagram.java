package org.manjunath.interview.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * If two strings s1 and s2 are said to be anagrams if both the strings having same characters,
 * no matter in which order they exist.
 * <br>
 * <code>
 *     Example:
 *     s1 = "abcde";
 *     s2 = "bdace"
 *     Now both s1 and s2 are said to be Anagrams.
 * </code>
 */
public class StringAnagram {


    public boolean isAnagramWithHashMap(String str1, String str2) {
        // if length of both strings are not equal then return false.
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create a map to store the Character counts. For the first iteration it will
        // increase the Character count, but in the second iteration it will decrement
        // the count value.
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Decrement the character count for second string
        for (char c : str2.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        // Check the values of map, so that it should have only count as 0
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram(String str1, String str2) {
        // if length of both strings are not equal then return false.
        if (str1.length() != str2.length()) {
            return false;
        }

        // Initialize an array of length 26. This will store the count of each character at specific index.
        // Character 'a' at index 0, 'b' at 1 etc.
        int[] alphabetsCount = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            // increase first string character count
            alphabetsCount[str1.charAt(i) - 'a']++;

            // decrease the second string character count
            alphabetsCount[str2.charAt(i) - 'a']--;
        }

        // After the first iteration if the strings are anagrams, then the array will contain elements as zero.
        for (int count: alphabetsCount) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramUsingStringBuilder(String str1, String str2) {
        // If strings are not equal then return false.
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create a StringBuilder with first string
        StringBuilder builder = new StringBuilder(str1);

        // Iterate through each character of second string
        for (char c : str2.toCharArray()) {
            // Get index of the character from the string builder
            int index = builder.indexOf(c + "");

            // if the index is not -1, then delete that character from the StringBuilder with index
            if (index != -1) {
                builder.deleteCharAt(index);
            }
        }
        // Return is the StringBuilder is empty or not
        return builder.isEmpty();
    }
}
