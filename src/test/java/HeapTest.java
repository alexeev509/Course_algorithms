import com.company.greedy.algorithms.heap.Heap;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;

public class HeapTest {
    @Test
    public void insertTest() throws Exception {
        ArrayList<Object> expected = new ArrayList<>(asList(3120, 2120, 200, 10));
        Heap.insertElementInMaxHeap(200);
        Heap.insertElementInMaxHeap(10);
        Heap.insertElementInMaxHeap(2120);
        List<Integer> actual = Heap.insertElementInMaxHeap(3120);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void extractMaxTest() throws Exception {
        ArrayList<Object> expected = new ArrayList<>(asList(500, 5, 10));
        Heap.insertElementInMaxHeap(10);
        Heap.insertElementInMaxHeap(5);
        List<Integer> actual = Heap.insertElementInMaxHeap(500);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        expected = new ArrayList<>(asList(10, 5));
        List<Integer> extractMaxListActual = Heap.extractMax();

        Assert.assertArrayEquals(expected.toArray(), extractMaxListActual.toArray());
    }

    @Test
    public void stepikTest() throws Exception {
        ArrayList<Object> expected = new ArrayList<>(asList(200, 10));
        Heap.insertElementInMaxHeap(200);
        List<Integer> actual = Heap.insertElementInMaxHeap(10);

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
        actual = Heap.extractMax();
        expected = new ArrayList<>(asList(10));
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        Heap.insertElementInMaxHeap(5);
        actual = Heap.insertElementInMaxHeap(500);
        expected = new ArrayList<>(asList(500, 5, 10));

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

        actual = Heap.extractMax();
        expected = new ArrayList<>(asList(10, 5));
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
//        List<Integer> extractMaxListActual = Heap.extractMax();
//
//        Assert.assertArrayEquals(expected.toArray(),extractMaxListActual.toArray());
    }

    @Test
    public void stepikTest2() throws Exception {
        Heap.start(new Scanner("8\n"
                + "Insert 200\n"
                + "Insert 10\n"
                + "Insert 5\n"
                + "Insert 500\n"
                + "ExtractMax\n"
                + "ExtractMax\n"
                + "ExtractMax\n"
                + "ExtractMax\n"));
    }

    @Test
    public void stepikTest3() throws Exception {
        Heap.start(new Scanner("8\n"
                + "Insert 2\n"
                + "Insert 3\n"
                + "Insert 15\n"
                + "Insert 18\n"
                + "Insert 12\n"
                + "ExtractMax\n"
                + "ExtractMax\n"
                + "ExtractMax\n"));
    }

    @Test
    public void stepikTest4() throws Exception {
        Heap.start(new Scanner("11\n"
                + "Insert 2\n"
                + "Insert 3\n"
                + "Insert 18\n"
                + "Insert 15\n"
                + "Insert 18\n"
                + "Insert 12\n"
                + "Insert 12\n"
                + "Insert 2\n"
                + "ExtractMax\n"
                + "ExtractMax\n"
                + "ExtractMax\n"));
    }
}


//Insert 200
//        Insert 10
//        Insert 5
//        Insert 500
//        ExtractMax
//        ExtractMax
//        ExtractMax
//        ExtractMax
