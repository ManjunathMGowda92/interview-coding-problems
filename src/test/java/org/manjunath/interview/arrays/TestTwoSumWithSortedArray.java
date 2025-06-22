package org.manjunath.interview.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestTwoSumWithSortedArray {
    private TwoSumWithSortedArray obj;

    @BeforeEach
    void initialize() {
        obj = new TwoSumWithSortedArray();
    }

    @AfterEach
    void destroy() {
        obj = null;
    }

    @Test
    void testTwoSumWithBinarySearch() {
        int[] arr = {2,7,11,15};
        int target = 9;

        int[] indices = obj.twoSumWithBinarySearch(arr, target);
        int[] expected = {1, 2};

        Assertions.assertArrayEquals(expected, indices);
    }

    @Test
    void testTwoSumWithBinarySearch_2() {
        int[] arr = {1,2,3,4,4,9,56,90};
        int target = 9;

        int[] indices = obj.twoSumWithBinarySearch(arr, target);
        int[] expected = {};

        Assertions.assertArrayEquals(expected, indices);
    }

    @Test
    void testTwoSumWithPointers() {
        int[] arr = {2,7,11,15};
        int target = 9;

        int[] indices = obj.twoSumWithPointers(arr, target);
        int[] expected = {1, 2};

        Assertions.assertArrayEquals(expected, indices);
    }

    @Test
    void testTwoSumWithPointers_2() {
        int[] arr = {1,2,3,4,4,9,56,90};
        int target = 10;

        int[] indices = obj.twoSumWithPointers(arr, target);
        int[] expected = {1, 6};

        Assertions.assertArrayEquals(expected, indices);
    }
}
