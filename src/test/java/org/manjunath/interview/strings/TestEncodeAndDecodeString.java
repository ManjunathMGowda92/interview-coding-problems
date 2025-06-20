package org.manjunath.interview.strings;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestEncodeAndDecodeString {
    private EncodeAndDecodeString obj;

    @BeforeEach
    void initialize() {
        obj = new EncodeAndDecodeString();
    }

    @AfterEach
    void destroy() {
        obj = null;
    }

    @Test
    void testEncode() {
        List<String> strings = List.of("abc", "def", "xy", "z", "mnop");
        String encodedString = obj.encode(strings);

        String expectedResult = strings.stream()
                .map(str -> str + Character.toString((char) 257))
                .reduce("", String::concat);
        expectedResult = expectedResult.substring(0, expectedResult.length() - 1);
        Assertions.assertEquals(expectedResult, encodedString);
    }

    @Test
    void testDecode() {
        String encoded = "abcādefāxyāzāmnop";
        List<String> actualResult = obj.decode(encoded);
        List<String> expectedResult = List.of("abc", "def", "xy", "z", "mnop");

        for (String str : expectedResult) {
            Assertions.assertTrue(actualResult.contains(str));
        }
    }

    @Test
    void testEncodeWithLength() {
        List<String> strings = List.of("abc", "def", "xy", "z", "mnop");
        String encodedString = obj.encodeWithLength(strings);

        String expectedResult = strings.stream()
                .map(str -> {
                    StringBuilder builder = new StringBuilder();
                    return builder.append(str.length()).append("#").append(str).toString();
                })
                .reduce("", String::concat);
        Assertions.assertEquals(expectedResult, encodedString);
    }

    @Test
    void testDecodeUsingLength() {
        String encoded = "3#abc3#def2#xy1#z4#mnop";
        List<String> actualResult = obj.decodeUsingLength(encoded);
        List<String> expectedResult = List.of("abc", "def", "xy", "z", "mnop");

        for (String str : expectedResult) {
            Assertions.assertTrue(actualResult.contains(str));
        }
    }
}
