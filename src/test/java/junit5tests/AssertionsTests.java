package junit5tests;

import listeners.Listener;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(Listener.class)

public class AssertionsTests {
    @Test
    void assertEqualsTest() {
        assertEquals("firstString", "secondString", "the string values were not equal");
    }

    @Test
    void assertEqualsListTest() {
        List<String> expectedValues = Arrays.asList("firstString", "secondString");
        List<String> actualValues = Arrays.asList("firstString", "secondString");
        assertEquals(expectedValues, actualValues);
    }

    @Test
    void assertArraysEqualsTest() {
        int[] expectedValues = {1, 2, 3};
        int[] actualValues = {1, 2, 3};
        Assertions.assertArrayEquals(expectedValues, actualValues);
    }

    @Test
    void assertTrueAssertion() {
        Assertions.assertFalse(false);
        Assertions.assertTrue(false, "this boolean condition did not evaluate tu true");
    }

    @Test
    void assertThrowsTest() {
        assertThrows(NullPointerException.class, null);
    }

    @Test
    void assertAllTest() {
        assertAll(() -> assertEquals("firstString", "secondString", "the string is not equal"),
                () -> assertThrows(NullPointerException.class, null),
                () -> Assertions.assertTrue(false, "this boolean condition did not evaluate to true"));
    }

    @Test
    void assertForMapTest() {
        Map<String, Integer> theMap = new HashMap<>();
        theMap.put("firstKey", 1);
        theMap.put("secondKey", 2);
        theMap.put("thirdKey", 3);
        assertThat(theMap, Matchers.hasValue(2));
        assertThat(theMap, Matchers.hasKey("secondKey"));
    }

    @Test
    void assertForList() {
        List<String> theList = Arrays.asList("firstString", "secondString", "thirdString");
        assertThat(theList, hasItem("thirdString"));
    }

    @Test
    void assertForAnyOf() {
        List<String> theList = Arrays.asList("firstString", "secondString", "thirdString");
        assertThat(theList, anyOf(hasItem("thirdString"), hasItem("noString")));
    }

    @Test
    void assertForContainsAllOf() {
        List<String> theList = Arrays.asList("firstString", "secondString", "thirdString");
        assertThat(theList, allOf(hasItem("firstString"), hasItem("secondString")));
    }

    @Test
    void assertForContainsInAnyOrder() {
        List<String> theList = Arrays.asList("firstString", "secondString", "thirdString");
        assertThat(theList, containsInAnyOrder("firstString", "secondString","thirdString"));
    }
}
