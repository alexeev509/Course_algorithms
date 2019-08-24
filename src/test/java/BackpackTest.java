import com.company.greedy.algorithms.Backpack;
import org.junit.Test;

import java.util.Scanner;

public class BackpackTest {
    @Test
    public void firstTest() throws Exception {
        Double maxSumm = Backpack.getMaxSumm(new Scanner("3\n50\n60\n20\n100\n50\n120\n20"));
        System.out.println(maxSumm);
    }
}
