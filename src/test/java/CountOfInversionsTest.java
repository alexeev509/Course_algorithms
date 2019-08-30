import com.company.divide.and.rule.CountOfInversions;
import org.junit.Test;

import java.util.Scanner;

public class CountOfInversionsTest {
    @Test
    public void testcountOfInversionsTest() throws Exception {
        CountOfInversions.getCountOfInversions(new Scanner("7\n7\n6\n5\n4\n3\n2\n1"));
    }

    @Test
    public void testcountOfInversionsTest2() throws Exception {
        CountOfInversions.getCountOfInversions(new Scanner("5\n" +
                "2\n3\n9\n2\n9"));
    }
}
