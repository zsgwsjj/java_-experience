package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : jiang
 * @time : 2018/5/14 17:13
 */
public class GenericsDemo2 {

    private void doTest() {
        List<String> stringList = new ArrayList<String>();
        List<Integer> integerList = new ArrayList<Integer>();

        Class classStringList = stringList.getClass();
        Class classIntegerList = integerList.getClass();

        if (classStringList.equals(classIntegerList)) {
            System.out.println("类型相同");

        }
    }

    public static void main(String[] args) {
        new GenericsDemo2().doTest();
    }
}
