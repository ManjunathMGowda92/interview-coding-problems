package org.manjunath.interview.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Sort the given input list based on number of occurrence of elements. Highest occurring element should be placed first in the List
 */
public class SortListByElementOccurrence {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(List.of(1, 3, 5, 8, 2, 5, 8, 1, 5, 5, 8, 3));
        sortListBasedOnElementOccurrenceMethod1(integers);
        System.out.println("--------------------------");
        createSortedListBasedOnCount(integers);
    }

    private static void sortListBasedOnElementOccurrenceMethod1(List<Integer> integers) {
        // Using Collection.frequency method will not generate the accurate output
        List<Integer> list = integers.stream()
                .sorted(Comparator.comparing(num -> Collections.frequency(integers, num)).reversed())
                .toList();
        integers.sort(Comparator.comparing(num -> Collections.frequency(integers, num)).reversed());

        System.out.println(list);     // [5, 5, 5, 5, 8, 8, 8, 1, 3, 1, 3, 2]
        System.out.println(integers); // [5, 5, 5, 5, 8, 8, 8, 1, 3, 1, 3, 2]
    }

    private static void createSortedListBasedOnCount(List<Integer> list) {
        // Use Map occurrence method to create a sorted list
        List<Integer> list1 = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // convert the list to map based on count of elements.
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // sort the map based on occurrence (highest first)
                .map(entry -> generateList(entry.getKey(), entry.getValue())) // create lists with the help of number of occurrence
                .flatMap(List::stream) // Flatten the Lists to Stream of integers
                .toList();  // Collect them to list
        System.out.println(list1);   // [5, 5, 5, 5, 8, 8, 8, 1, 1, 3, 3, 2]

    }

    private static List<Integer> generateList( Integer listEntry, Long size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(listEntry);
        }
        return numbers;
    }
}
