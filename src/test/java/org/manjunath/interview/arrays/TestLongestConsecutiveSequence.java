package org.manjunath.interview.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLongestConsecutiveSequence {
    private LongestConsecutiveSequence obj;

    @BeforeEach
    void initialize() {
        obj = new LongestConsecutiveSequence();
    }

    @AfterEach
    void destroy() {

    }

    @Test
    void testLongestConsecutive() {
        int longestConsecutive = obj.longestConsecutive(new int[]{-1, -1, 0, 1, 3, 5, 7, 9, 4, 6});
        Assertions.assertEquals(5, longestConsecutive);
    }

    @Test
    void testLongestConsecutive_2() {
        int longestConsecutive = obj.longestConsecutive(new int[]{-1, 0});
        Assertions.assertEquals(2, longestConsecutive);
    }

    @Test
    void testLongestConsecutive_3() {
        int longestConsecutive = obj.longestConsecutive(new int[]{-1, 0, 2, -3});
        Assertions.assertEquals(2, longestConsecutive);
    }

    @Test
    void testLongestConsecutive_4() {
        int longestConsecutive = obj.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});
        Assertions.assertEquals(9, longestConsecutive);
    }

    @Test
    void testLongestConsecutive_5() {
        int longestConsecutive = obj.longestConsecutive(new int[]{1,0,1,2});
        Assertions.assertEquals(3, longestConsecutive);
    }

    @Test
    void testLongestConsecutive_6() {
        int longestConsecutive = obj.longestConsecutive(new int[]{7,-9,3,-6,3,5,3,6,-2,-5,8,6,-4,-6,-4,-4,5,-9,2,7,0,0});
        Assertions.assertEquals(4, longestConsecutive);
    }

    @Test
    void testLongestConsecutiveForNullAndEmpty() {
        Assertions.assertEquals(0, obj.longestConsecutive(null));
        Assertions.assertEquals(0, obj.longestConsecutive(new int[]{}));
    }

    @Test
    void testLongestConsecutiveUsingSet() {
        int longestConsecutive = obj.longestConsecutiveUsingSet(new int[]{-1, -1, 0, 1, 3, 5, 7, 9, 4, 6});
        Assertions.assertEquals(5, longestConsecutive);
    }

    @Test
    void testLongestConsecutiveUsingSet_2() {
        int longestConsecutive = obj.longestConsecutiveUsingSet(new int[]{-1, 0});
        Assertions.assertEquals(2, longestConsecutive);
    }

    @Test
    void testLongestConsecutiveUsingSet_3() {
        int longestConsecutive = obj.longestConsecutiveUsingSet(new int[]{-1, 0, 2, -3});
        Assertions.assertEquals(2, longestConsecutive);
    }

    @Test
    void testLongestConsecutiveUsingSet_4() {
        int longestConsecutive = obj.longestConsecutiveUsingSet(new int[]{0,3,7,2,5,8,4,6,0,1});
        Assertions.assertEquals(9, longestConsecutive);
    }

    @Test
    void testLongestConsecutiveUsingSet_5() {
        int longestConsecutive = obj.longestConsecutiveUsingSet(new int[]{1,0,1,2});
        Assertions.assertEquals(3, longestConsecutive);
    }

    @Test
    void testLongestConsecutiveUsingSet_6() {
        int longestConsecutive = obj.longestConsecutiveUsingSet(new int[]{7,-9,3,-6,3,5,3,6,-2,-5,8,6,-4,-6,-4,-4,5,-9,2,7,0,0});
        Assertions.assertEquals(4, longestConsecutive);
    }

    @Test
    void testLongestConsecutiveUsingSetWithNullAndEmpty() {
        Assertions.assertEquals(0, obj.longestConsecutiveUsingSet(null));
        Assertions.assertEquals(0, obj.longestConsecutiveUsingSet(new int[]{}));
    }








}
