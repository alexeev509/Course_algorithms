import com.company.divide.and.rule.QuickSortRealizations.QuickSort;
import com.company.divide.and.rule.QuickSortRealizations.QuickSortMiddlePivotElement;
import com.company.divide.and.rule.QuickSortRealizations.QuickSortTailRecursion;
import com.company.divide.and.rule.QuickSortRealizations.QuickSortThreeDevides;
import com.company.divide.and.rule.TaskAboutLinesAndPointsQuickSort;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

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

    @Test
    public void testQuickSortWithMiddleElement() throws Exception {
        int[] actual = new int[]{44, 66, 1, 8, 14, 22, 99, 3};
        int[] expected = Arrays.copyOf(actual, actual.length);

        actual = QuickSortMiddlePivotElement.sort(actual, 0, actual.length);
        Arrays.sort(expected);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testQuickSortWithTailRecursion() throws Exception {
        int[] actual = new int[]{44, 66, 1, 8, 14, 22, 99, 3};
        int[] expected = Arrays.copyOf(actual, actual.length);

        actual = QuickSortTailRecursion.sort(actual, 0, actual.length);
        Arrays.sort(expected);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testQuickSortForLinesAndPoints() throws Exception {
        int[] actual = new int[]{44, 66, 1, 8, 8, 8, 14, 22, 99, 3};
        int[] expected = Arrays.copyOf(actual, actual.length);
        TaskAboutLinesAndPointsQuickSort.start(new Scanner(new File("src/test/testQuickSort.txt")));
//        actual = QuickSortThreeDevides.quickSort(actual, 0, actual.length);
//        Arrays.sort(expected);

//        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void testQuickSortThreeDevides() throws Exception {
        int[] actual = new int[]{44, 66, 1, 8, 8, 8, 14, 22, 99, 3};
        int[] expected = Arrays.copyOf(actual, actual.length);
        actual = QuickSortThreeDevides.qSort(actual, 0, actual.length - 1);
        Arrays.sort(expected);

        Assert.assertArrayEquals(expected, actual);
    }
}
