package org.manjunath.interview.arrays;

import java.util.HashSet;
import java.util.Set;

public class DuplicateElements {

    public boolean isDuplicatesFound(int[] arr) {
        // Create Hashset to store the elements.
        Set<Integer> set = new HashSet<>();

        // Iterate through each element of array
        for (int i : arr) {
            // Add each element to Set, if the set is already exist with the element, then it will return false.
            // So return true as duplicates exists.
            if (!set.add(i)) {
                return true;
            }
        }

        // If no duplicate found, then return false.
        return false;
    }
}
