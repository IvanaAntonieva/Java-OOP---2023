package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {
    @Test
    public void testBubbleSort() {
        int[] array = {6, 5, 3, 1, 8, 7, 2, 4};
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8};
        Bubble.sort(array);
        Assert.assertArrayEquals(sortedArray, array);
    }
}
