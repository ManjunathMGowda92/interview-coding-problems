package org.manjunath.interview.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDuplicateElements {
    private DuplicateElements obj;

    @BeforeEach
     void initialize() {
        obj = new DuplicateElements();
    }

    @AfterEach
     void destroy() {
        obj = null;
    }

    @Test
    void testIsDuplicatesFound_ForDuplicates() {
        int[] arr1 = {1, 4, 2, 5, 7, 2, 8, 9};
       Assertions.assertTrue(obj.isDuplicatesFound(arr1));
    }

    @Test
    void testIsDuplicatesFound() {
        int[] arr2 = {9, 5, 3, 1, 6, 8};
        Assertions.assertFalse(obj.isDuplicatesFound(arr2));
        Assertions.assertFalse(obj.isDuplicatesFound(new int[]{}));
    }
}
