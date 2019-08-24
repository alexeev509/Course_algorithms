import com.company.greedy.algorithms.haffman.HaffmanCode;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
}
