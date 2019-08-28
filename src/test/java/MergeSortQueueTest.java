import com.company.divide.and.rule.MergeSortQueue;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MergeSortQueueTest {
    @Test
    public void firstMergeSortTest() throws Exception {
        int[] expected = MergeSortQueue.insertRandomNumbersInMass(16);
        int[] actual = Arrays.copyOf(expected, expected.length);

        actual = MergeSortQueue.mergeSort(actual);

        Arrays.sort(expected);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void secondMergeSortTest() throws Exception {
        int[] expected = MergeSortQueue.insertRandomNumbersInMass(17);
        int[] actual = Arrays.copyOf(expected, expected.length);

        actual = MergeSortQueue.mergeSort(actual);

        Arrays.sort(expected);

        Assert.assertArrayEquals(expected, actual);
    }
}
