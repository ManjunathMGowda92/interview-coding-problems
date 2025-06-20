package org.manjunath.interview.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestFindDuplicates {
    private FindDuplicates obj;

    @BeforeEach
    void initialize() {
        obj = new FindDuplicates();
    }

    @AfterEach
    void destroy() {
        obj = null;
    }

    @Test
    void testFindDuplicatesInArray() {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> duplicates = obj.findDuplicatesFromArray(arr);

        Assertions.assertTrue(duplicates.contains(2));
        Assertions.assertTrue(duplicates.contains(3));
    }

    @Test
    void testFindDuplicatesInArray2() {
        int[] arr = {4,3,2,7,8,1};
        List<Integer> duplicates = obj.findDuplicatesFromArray(arr);

        Assertions.assertTrue(duplicates.isEmpty());
    }
}
