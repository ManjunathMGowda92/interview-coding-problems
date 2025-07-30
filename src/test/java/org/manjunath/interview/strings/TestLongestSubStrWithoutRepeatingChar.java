package org.manjunath.interview.strings;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TestLongestSubStrWithoutRepeatingChar {
    private LongestSubStrWithoutRepeatingChar obj;

    @BeforeEach
    void initialize() {
        obj = new LongestSubStrWithoutRepeatingChar();
    }

    @AfterEach
    void destroy() {
        obj = null;
    }

    @ParameterizedTest
    @MethodSource("dataSource")
    void testSubStrWithoutRepeatingChar(String str, int expectedLength) {
        Assertions.assertEquals(expectedLength, obj.subStrWithoutRepeatingChar(str));
    }

    private static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of("abcdw33aedfr", 6),
                Arguments.of("abcedthyj", 9),
                Arguments.of("abcbcdba", 4),
                Arguments.of("ababcdcthge", 6)
        );
    }
}