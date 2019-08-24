import com.company.greedy.algorithms.PointsAndLines;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

public class PointsAndLinesTest {
    @Test
    public void insertSortTest() throws Exception {
        int[][] expected = new int[][]{{1, 3}, {2, 5}, {5, 6},{4, 7}};
        int[][] actual = PointsAndLines.insertSort(new int[][]{{4, 7}, {1, 3}, {2, 5}, {5, 6}});
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(expected[i], actual[i]);
        }

    }
    @Test
    public void getPointsTest() throws Exception {
        int[][] expected = new int[][]{{1, 3}, {2, 5}, {5, 6},{4, 7}};
        List<Integer> actual = PointsAndLines.getPoints(new Scanner(
                "4\n4\n7\n1\n3\n2\n5\n5\n6"));
    }
}
