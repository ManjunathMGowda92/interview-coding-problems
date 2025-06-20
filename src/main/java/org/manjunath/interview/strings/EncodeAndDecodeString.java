package org.manjunath.interview.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EncodeAndDecodeString {

    /* APPROACH -1 : Using a UNICODE delimiter as postfix for each string */

    /**
     * Method to encode given list of strings into a single string.
     * In this approach we are using a delimiter Character (From UNICODE) and will append the delimiter
     * at end of each string from the List except the last String.
     *
     * @param strs List of Strings
     * @return Encoded String object.
     */
    public String encode(List<String> strs) {
        // If the list is empty return 257th UNICODE char
        String delimiter = Character.toString((char) 257);
        if (strs.isEmpty()) {
            return delimiter;
        }

        // Create a StringBuilder object to add each string from list.
        // After adding each string append it with the delimiter.
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str).append(delimiter);
        }

        // Remove the last delimiter from StringBuilder
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    /**
     * Method to decode the given string to list of Strings.
     * In this approach we will use the same delimiter used in encode method
     * and then split the String to get the array of strings separated.
     *
     * @param s Encoded String for decoding.
     * @return List of Strings after decoding.
     */
    public List<String> decode(String s) {
        if (s.equals(Character.toString((char) 257))) {
            return Collections.emptyList();
        }

        String delimiter = Character.toString((char) 257);
        return Arrays.asList(s.split(delimiter, -1));
    }

    /* APPROACH - 2 : Using Length and ASCII delimiter as prefix for each string */

    /**
     * Method to convert each string from the list to a encoded string.
     * In this approach we will use the length of each string and '#' character as prefix for each string.
     * Where length will help in identifying the next String length and # will help in
     * extracting the next string length
     *
     * @param strs List of Strings for encoding.
     * @return Encoded String value.
     */
    public String encodeWithLength(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str.length()).append("#")
                    .append(str);
        }
        return builder.toString();
    }

    /**
     * Method to decode the given string and convert into List of strings.
     * In this method length of next string will be extracted by using 2 pointers
     * and then each string will be stored in the List.
     *
     * @param s Encoded String value.
     * @return List of Strings after decoding.
     */
    public List<String> decodeUsingLength(String s) {
        List<String> result = new ArrayList<>();

        // Create 2 pointer i and j, initialize i = 0 and j = i
        int i = 0;
        while (i < s.length()) { // Iterate through the string it the end of string.
            int j = i;  // Assign j to point where i is pointing in String
            while (s.charAt(j) != '#') { // iterate the j to find the position of # character.
                j++;
            }

            // When # character is determined, then we can use i and j indices to get
            // the length of next string
            int length = Integer.parseInt(s.substring(i, j));

            // After getting the next string length increment i to j+1 index to point
            // at the start of next chunk of string
            i = j + 1;

            // Extract the Substring from ith index to i+length characters.
            result.add(s.substring(i, i + length));

            // increment i for next iteration by adding the current string chunk length.
            i += length;
        }
        return result;
    }
}
