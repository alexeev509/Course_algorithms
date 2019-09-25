import com.company.dynamic.Backpack;
import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class BackpackDynamicTest {
    @Test
    public void backpackFirstTest() throws Exception {
        Backpack backpack = new Backpack(new Scanner("10\n" +
                "4\n" +
                "6\n" +
                "30\n" +
                "3\n" +
                "14\n" +
                "4\n" +
                "16\n" +
                "2\n" +
                "9"));
        int actual = backpack.getMaxSumm();
        int expected = 46;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void backpackSecondTest() throws Exception {
        Backpack backpack = new Backpack(new Scanner("13\n" +
                "5\n" +
                "3\n" +
                "1\n" +
                "4\n" +
                "6\n" +
                "5\n" +
                "4\n" +
                "8\n" +
                "7\n" +
                "9\n" +
                "6"));
        int actual = backpack.getMaxSumm();
        int expected = 13;
        Assert.assertEquals(actual, expected);
    }
}
