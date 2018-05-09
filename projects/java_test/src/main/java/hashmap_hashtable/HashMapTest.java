package hashmap_hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : jiang
 * @time : 2018/5/8 18:59
 */
public class HashMapTest {

    private HashMap<String, Object> map = new HashMap<>();

    public void doTest() {
        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), i);
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
    }

    public static void main(String[] args) {
        new HashMapTest().doTest();
    }
}
