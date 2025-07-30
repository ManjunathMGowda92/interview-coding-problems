package org.manjunath.interview.arrays;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMaximumPointsFromCards {
    private MaximumPointsFromCards obj;

    @BeforeEach
    void initialize() {
        obj = new MaximumPointsFromCards();
    }

    @AfterEach
    void destroy() {
        obj = null;
    }

    @Test
    void testMaxPointsFromCards() {
        int[] cards = {6, 2, 3, 4, 7, 2, 1, 7, 1};
        Assertions.assertEquals(14, obj.maxPointsFromCards(cards, 3)); //14

        Assertions.assertEquals(16, obj.maxPointsFromCards(cards, 4)); //16
    }

}