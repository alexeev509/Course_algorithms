import com.company.dynamic.BiggestSequence;
import com.company.dynamic.BiggestSequenceWithDevide;
import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class BiggestSequenseTest {
    @Test
    public void testFindBiggestSequence() throws Exception {
        int actual = BiggestSequence.run(new Scanner("4\n3\n6\n7\n12"));
        int expected = 4;

        Assert.assertEquals(expected, actual);

    }


    @Test
    public void testFindBiggestSequenceDevide() throws Exception {
        int actual = BiggestSequenceWithDevide.run(new Scanner("4\n3\n6\n7\n12"));
        int expected = 3;

        Assert.assertEquals(expected, actual);

    }
}
