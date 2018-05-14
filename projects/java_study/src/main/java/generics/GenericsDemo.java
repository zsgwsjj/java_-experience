package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : jiang
 * @time : 2018/5/14 17:13
 */
public class GenericsDemo {

    private void doTest() {
        List arrayList = new ArrayList();
//        List<String> arrayList = new ArrayList<>();
        arrayList.add("jiang");
        arrayList.add(100);

        for (Object anArrayList : arrayList) {
            String item = (String) anArrayList;
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        new GenericsDemo().doTest();
    }
}
