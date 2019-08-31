import com.company.divide.and.rule.QuickSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class QuickSortTest {
    @Test
    public void testQuichSort() throws Exception {
        int[] actual = new int[]{44, 66, 1, 8, 14, 22, 99, 3};
        int[] expected = Arrays.copyOf(actual, actual.length);

        actual = QuickSort.quickSort(actual, 0, actual.length);
        Arrays.sort(expected);

        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void testQuichSortRandom() throws Exception {
        int[] actual = QuickSort.insertRandomNumbersInMass(17);
        int[] expected = Arrays.copyOf(actual, actual.length);

        actual = QuickSort.quickSort(actual, 0, actual.length);
        Arrays.sort(expected);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testQuichSortTwoNumbers() throws Exception {
        int[] actual = new int[]{55, 1};
        int[] expected = Arrays.copyOf(actual, actual.length);

        actual = QuickSort.quickSort(actual, 0, actual.length);
        Arrays.sort(expected);

        Assert.assertArrayEquals(expected, actual);
    }
}