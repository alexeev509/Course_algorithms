import com.company.greedy.algorithms.MaxRepresentationOfNumber;
import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;
import java.util.Set;

public class RepresentationOfNumberTest {
    @Test
    public void representationNumberZeroTest() throws Exception {
        Set<Integer> actual = MaxRepresentationOfNumber.getRepresentsationOfNumber(new Scanner("4"));
        Assert.assertEquals(2,actual.size());
    }
    @Test
    public void representationNumberFirstTest() throws Exception {
        Set<Integer> actual = MaxRepresentationOfNumber.getRepresentsationOfNumber(new Scanner("6"));
        Assert.assertEquals(3,actual.size());
    }
    @Test
    public void representationNumberSecondTest() throws Exception {
        Set<Integer> actual = MaxRepresentationOfNumber.getRepresentsationOfNumber(new Scanner("15"));
        Assert.assertEquals(5,actual.size());
    }

    @Test
    public void representationNumberThirdTest() throws Exception {
        Set<Integer> actual = MaxRepresentationOfNumber.getRepresentsationOfNumber(new Scanner("14"));
        Assert.assertEquals(4,actual.size());
    }
}
