package org.manjunath.interview.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    /**
     * Method to group the given strings into anagram string groups. Find out each string
     * is anagram of other, then group them in a List.
     * @param strs Array of Strings.
     * @return Grouped Anagram String Lists
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // if the length of the input array is 0, then return Empty List.
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        // Create a HashMap to store the grouped anagram strings.
        Map<String, List<String>> map = new HashMap<>();

        // Iterate through each string and generate a unique string as
        // Anagram String to store as key, also store the respective string against to it.
        for (String str: strs) {
            String anagramString = getAnagramString(str);
            List<String> list = map.getOrDefault(anagramString, new ArrayList<>());
            list.add(str);
            map.put(anagramString, list);
        }

        // Return the map values (group of anagram strings)
        return new ArrayList<>(map.values());
    }

    /**
     * Method to generate unique anagram string against each input string using constant array with 26 indices.
     * @param str Input string
     * @return Unique Anagram string
     */
    private String getAnagramString(String str) {
        int[] count = new int[26];
        // Iterate through each of the character from string and store the count
        // value against to it in the array index
        for (char c: str.toCharArray()) {
            count[c-'a']++;
        }

        // Convert the counts stored against each index to unique string using StringBuffer or StringBuilder
        StringBuilder buffer = new StringBuilder();
        for (int j : count) {
            buffer.append("#");
            buffer.append(j);
        }

        // return the String value of buffer.
        return buffer.toString();
    }
}
