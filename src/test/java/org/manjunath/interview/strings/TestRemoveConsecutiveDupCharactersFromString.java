package org.manjunath.interview.strings;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestRemoveConsecutiveDupCharactersFromString {
    private RemoveConsecutiveDupCharactersFromString obj;

    @BeforeEach
    void initialize() {
        obj = new RemoveConsecutiveDupCharactersFromString();
    }

    @AfterEach
    void destroy() {
        obj = null;
    }

    @Test
    void testRemoveDuplicatesWithLinearApproach() {
        String str = "aaaaabbbbbb";
        Assertions.assertEquals("ab", obj.removeDuplicatesWithLinearApproach(str));
    }

    @Test
    void testRemoveDuplicatesWithLinearApproach2() {
        String str = "geeksforgeeks";
        Assertions.assertEquals("geksforgeks", obj.removeDuplicatesWithLinearApproach(str));
    }

    @Test
    void testRemoveDuplicatesWithLinearApproach3() {
        String str = "aabccba";
        Assertions.assertEquals("abcba", obj.removeDuplicatesWithLinearApproach(str));
    }

    @Test
    void testRemoveDuplicatesWithLinearApproach4() {
        String str = "aa";
        Assertions.assertEquals("a", obj.removeDuplicatesWithLinearApproach(str));
    }

    @Test
    void testRemoveDuplicatesWithLinearApproach5() {
        String str = "a";
        Assertions.assertEquals("a", obj.removeDuplicatesWithLinearApproach(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    @NullSource
    void testRemoveDuplicatesWithLinearApproachForNullOrEmpty(String str) {
        Assertions.assertNull( obj.removeDuplicatesWithLinearApproach(str));
    }

    @Test
    void testRemoveDuplicatesWithSlidingWindow() {
        String str = "aaaaabbbbbb";
        Assertions.assertEquals("ab", obj.removeDuplicatesWithSlidingWindow(str));
    }

    @Test
    void testRemoveDuplicatesWithSlidingWindow2() {
        String str = "geeksforgeeks";
        Assertions.assertEquals("geksforgeks", obj.removeDuplicatesWithSlidingWindow(str));
    }

    @Test
    void testRemoveDuplicatesWithSlidingWindow3() {
        String str = "aabccba";
        Assertions.assertEquals("abcba", obj.removeDuplicatesWithSlidingWindow(str));
    }

    @Test
    void testRemoveDuplicatesWithSlidingWindow4() {
        String str = "aa";
        Assertions.assertEquals("a", obj.removeDuplicatesWithSlidingWindow(str));
    }

    @Test
    void testRemoveDuplicatesWithSlidingWindow5() {
        String str = "a";
        Assertions.assertEquals("a", obj.removeDuplicatesWithSlidingWindow(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    @NullSource
    void testRemoveDuplicatesWithSlidingWindowForEmptyOrNull(String str) {
        Assertions.assertNull( obj.removeDuplicatesWithSlidingWindow(str));
    }
}
