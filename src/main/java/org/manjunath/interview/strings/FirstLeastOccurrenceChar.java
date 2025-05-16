package org.manjunath.interview.strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Finding the first least occurrence character from the String in both the traditional way and Functional programming way.
 */
public class FirstLeastOccurrenceChar {

    public static void main(String[] args) {
        String str = "ashyrsavhjsbcserdbseft";
        findFirstLeastOccurredCharacter(str);
        findFirstLeastOccurredCharFunctional(str);
    }

    private static void findFirstLeastOccurredCharFunctional(String str) {
        // WAY 1: Using groupingBy Function
        Optional<String> firstOccurrence = str.chars()  // convert the String into intStream
                .mapToObj(Character::toString) // Map each integer to single character string
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // Collect the individual Character into map using groupingBy function.
                .entrySet() //get entry set for created map.
                .stream() // get stream on entry set
                .filter(entry -> entry.getValue() == 1) // filter the objects which are having single occurrence
                .map(Map.Entry::getKey) // map single occurrence entry to extract key only
                .findFirst(); // get the first occurrence
        firstOccurrence.ifPresent(System.out::println);

        // WAY 2: Using Collectors.toMap() function
        Optional<String> firstOccurrenceChar = str.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.toMap(key -> key, value -> 1, (oldValue, newValue) -> oldValue + newValue, LinkedHashMap::new))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
        firstOccurrenceChar.ifPresent(System.out::println);

    }

    /**
     * Method which finds the least occurrence character from the string in a traditional approach using the for loop.
     *
     * @param str Input String object to find the first least occurrence character
     */
    private static void findFirstLeastOccurredCharacter(String str) {
        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
                break;
            }
        }
    }
}
