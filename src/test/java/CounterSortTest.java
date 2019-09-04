import com.company.count.sort.CountSort;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CounterSortTest {

    @Test
    public void countSortTest0() throws Exception {
        int[] expected = new int[]{2, 1, 1, 1, 3, 2, 2, 2, 3, 2, 3, 2, 2, 1, 1};
        writeMassToFile(expected, "src/test/testCounterSort.txt");

        Arrays.sort(expected);
        int[] actual = CountSort.run(new Scanner(new File("src/test/testCounterSort.txt")));

        System.out.println(Arrays.toString(actual));
        System.out.println(Arrays.toString(expected));
    }

    @Test
    public void countSortTest() throws Exception {
        int[] expected = generateMass(100, 10);
        writeMassToFile(expected, "src/test/testCounterSort.txt");

        Arrays.sort(expected);
        int[] actual = CountSort.run(new Scanner(new File("src/test/testCounterSort.txt")));

        Assert.assertArrayEquals(expected, actual);
    }

    private int[] generateMass(int lenght, int max) {
        Random r = new Random();
        int[] mass = new int[lenght];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = r.nextInt(max) + 1;
        }
        return mass;
    }

    private void writeMassToFile(int[] mass, String filePath) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(new File(filePath)));
        writer.write(mass.length + "\n");
        for (int i = 0; i < mass.length; i++) {
            writer.write(mass[i] + " ");
        }
        writer.flush();
    }
}
