package ru.itis.inf304.lab2_7_test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;

public class BubbleSortTest {

    @Test
    public void testBubbleSort() {
        int[] arr = {4, 5, 3, 6, 8, 3, 2};
        int[] expectedSortedArr = {2, 3, 3, 4, 5, 6, 8};
        Assert.assertArrayEquals(BubbleSort.bubbleSort(arr), expectedSortedArr);
    }
}
