import com.company.greedy.algorithms.haffman.HaffmanCode;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HaffmanTest {
    @Test
    public void testGetFrequencyOfChars() throws Exception {
        Map<Character, Integer> expected=new HashMap<>();
        expected.put('a',4);
        expected.put('b',2);
        expected.put('c',1);
        expected.put('d',2);

        Map<Character, Integer> actual = HaffmanCode.getFrequencyOfChars("abacabadd");
        for (Map.Entry<Character, Integer> entry : actual.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testGetOptimalCode() throws Exception {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 4);
        expected.put('b', 2);
        expected.put('c', 1);
        expected.put('d', 2);

        StringBuffer actual = HaffmanCode.getOptimalCode(new Scanner("abacabad"));
        System.out.println(actual.toString());
    }

    @Test
    public void testGetOptimalCode2() throws Exception {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('c', 2);
        expected.put('e', 2);
        expected.put('p', 1);
        expected.put('t', 1);
        expected.put('d', 1);

        StringBuffer actual = HaffmanCode.getOptimalCode(new Scanner("accepted"));
        System.out.println(actual.toString());
    }

    @Test
    public void testGetOptimalCode3() throws Exception {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);

        StringBuffer actual = HaffmanCode.getOptimalCode(new Scanner("a"));
        System.out.println(actual.toString());
    }

}
//accepted