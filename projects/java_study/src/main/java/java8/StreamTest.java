package java8;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : jiang
 * @time : 2018/5/9 15:43
 */
public class StreamTest {
    private List<String> testList = Arrays.asList("a", "b", "c", "d", "e", "f");

    public static void main(String[] args) {
        StreamTest streamTest = new StreamTest();
        streamTest.streamTest1();
    }

    private void do1() {
        for (String s : testList) {
            System.out.println(s);
        }
    }

    private void do2() {
        Iterator<String> iterator = testList.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private void do3() {
        testList.forEach(System.out::println);
    }

    private void streamTest1() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7);
        stream.forEach(System.out::println);
    }

    private void test1() {
        Arrays arrays ;

    }

}
