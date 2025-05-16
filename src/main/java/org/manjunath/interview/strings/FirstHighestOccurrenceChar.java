package org.manjunath.interview.strings;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Finding the first highest occurrence character from the String using Functional programming way.
 */
public class FirstHighestOccurrenceChar {

    public static void main(String[] args) {
        String str = "ashyrsavhjsbcserdbseft";
        findFirstHighestOccurredCharFunctional(str);
    }


    private static void findFirstHighestOccurredCharFunctional(String str) {
        Optional<String> highestOccurredChar = str.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .stream().findFirst();
        highestOccurredChar.ifPresent(System.out::println);
    }
}
