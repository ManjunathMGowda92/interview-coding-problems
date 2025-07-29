package org.manjunath.interview.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestFindMissingNumber {
    private FindMissingNumber obj;

    @BeforeEach
    void initialize() {
        obj = new FindMissingNumber();
    }

    @AfterEach
    void destroy() {
        obj = null;
    }

    @Test
    void testMissingNumWithXor() {
        int actualResult = obj.missingNumWithXor(new int[]{1, 2, 3, 5});
        Assertions.assertEquals(4, actualResult);
    }

    @Test
    void testMissingNumWithXor2() {
        int actualResult = obj.missingNumWithXor(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10});
        Assertions.assertEquals(9, actualResult);
    }

    @Test
    void testFindMissingNumber() {
        int actualResult = obj.findMissingNumber(new int[]{0, 1, 2, 3, 5});
        Assertions.assertEquals(4, actualResult);
    }

    @Test
    void testFindMissingNumber2() {
        int actualResult = obj.findMissingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 10});
        Assertions.assertEquals(9, actualResult);
    }

}