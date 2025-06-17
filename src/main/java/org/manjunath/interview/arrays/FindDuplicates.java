package org.manjunath.interview.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicates {

    public List<Integer> findDuplicatesFromArray(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> numbers = new HashSet<>();

        for (int num : nums) {
            if (!numbers.add(num)) {
                duplicates.add(num);
            }
        }
        return duplicates;
    }
}
