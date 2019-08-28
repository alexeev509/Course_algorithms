import com.company.divide.and.rule.MergeSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MergeSortTest {
    @Test
    public void firstMergeSortTest() throws Exception {
        int[] actual = MergeSort.insertRandomNumbersInMass(8);
        int[] expected = Arrays.copyOf(actual, actual.length);
        System.out.println(Arrays.toString(actual));
        System.out.println(Arrays.toString(expected));

        MergeSort.mergeSort(actual, 0, actual.length - 1);
        Arrays.sort(expected);

        System.out.println(Arrays.toString(actual));
        System.out.println(Arrays.toString(expected));

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void secondMergeSortTest() throws Exception {
        int[] actual = MergeSort.insertRandomNumbersInMass(9);
        int[] expected = Arrays.copyOf(actual, actual.length);

        System.out.println(Arrays.toString(actual));
        System.out.println(Arrays.toString(expected));

        MergeSort.mergeSort(actual, 0, actual.length - 1);
        Arrays.sort(expected);


        System.out.println(Arrays.toString(actual));
        System.out.println(Arrays.toString(expected));


        Assert.assertArrayEquals(expected, actual);
    }
}
