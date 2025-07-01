package org.manjunath.interview.strings;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestStringAnagram {
    private StringAnagram obj;

    @BeforeEach
    void initialize() {
        obj = new StringAnagram();
    }

    @AfterEach
    void destroy() {
        obj = null;
    }

    @Test
    void testStringsAsAnagramUsingMap() {
        String str1 = "abcdefgh";
        String str2 = "cdaefbhg";

        Assertions.assertTrue(obj.isAnagramWithHashMap(str1, str2));
    }

    @Test
    void testStringsAsAnagramUsingArray() {
        String str1 = "abcdefgh";
        String str2 = "cdaefbhg";

        Assertions.assertTrue(obj.isAnagram(str1, str2));
    }

    @Test
    void testStringsNotAnagramUsingMap() {
        String str1 = "abcdefgh";
        String str2 = "cdaefbfhg";

        Assertions.assertFalse(obj.isAnagramWithHashMap(str1, str2));
    }

    @Test
    void testStringsNotAnagramUsingArray() {
        String str1 = "abcdefgh";
        String str2 = "cdaefbfhg";

        Assertions.assertFalse(obj.isAnagram(str1, str2));
    }

    @Test
    void testStringsNotAnagramUsingMapWithSamelength() {
        String str1 = "abcdefgh";
        String str2 = "cdaeffhg";

        Assertions.assertFalse(obj.isAnagramWithHashMap(str1, str2));
    }

    @Test
    void testStringsNotAnagramUsingArrayWithSameLength() {
        String str1 = "abcdefgh";
        String str2 = "cdafbfhg";

        Assertions.assertFalse(obj.isAnagram(str1, str2));
    }

    @Test
    void testIsAnagramUsingStringBuilder() {
        String str1 = "abcdefgh";
        String str2 = "cdafbfhg";

        Assertions.assertFalse(obj.isAnagramUsingStringBuilder(str1, str2));
    }

    @Test
    void testIsAnagramUsingStringBuilderForFalse() {
        String str1 = "abcdefgh";
        String str2 = "cdaefbhg";

        Assertions.assertTrue(obj.isAnagramUsingStringBuilder(str1, str2));
    }
}
