package org.manjunath.interview.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestProductOfArrayElementsExceptSelf {
    private ProductOfArrayElementsExceptSelf obj;

    @BeforeEach
    void initialize() {
        obj = new ProductOfArrayElementsExceptSelf();
    }

    @AfterEach
    void destroy() {
        obj = null;
    }

    @Test
    void testFindProductWith2Arrays() {
        int[] arr = {2, 1, 3, 5, 4};
        int[] expectedResult = {60, 120, 40, 24, 30};

        int[] actualResult = obj.findProduct(arr);
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void testFindProductWith2Arrays2() {
        int[] arr = {-2, 1, -3, 0, 4};
        int[] expectedResult = {0, 0, 0, 24, 0};

        int[] actualResult = obj.findProduct(arr);
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void testProductExceptSelf() {
        int[] arr = {2, 1, 3, 5, 4};
        int[] expectedResult = {60, 120, 40, 24, 30};

        int[] actualResult = obj.productExceptSelf(arr);
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void testProductExceptSelf2() {
        int[] arr = {-2, 1, -3, 0, 4};
        int[] expectedResult = {0, 0, 0, 24, 0};

        int[] actualResult = obj.productExceptSelf(arr);
        Assertions.assertArrayEquals(expectedResult, actualResult);
    }
}
