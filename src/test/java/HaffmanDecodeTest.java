import com.company.greedy.algorithms.haffman.DecodeHaffmanCode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class HaffmanDecodeTest {
    @Test
    public void decodeTest1() throws Exception {
        StringBuffer expected = new StringBuffer().append("a");
        StringBuffer actual = DecodeHaffmanCode.readInputAndDecode(
                new Scanner("1 1\na: 0\n0"));

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void decodeTest2() throws Exception {
        StringBuffer expected = new StringBuffer().append("a");
        StringBuffer actual = DecodeHaffmanCode.readInputAndDecode(
                new Scanner("3 10\n" +
                        "a: 00\n" +
                        "b: 1\n" +
                        "c: 01\n" +
                        "1011001011"));
        System.out.println(actual.toString());

//        Assert.assertEquals(expected.toString(),actual.toString());
    }
}
