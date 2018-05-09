package hashmap_hashtable;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author : jiang
 * @time : 2018/5/8 19:06
 */
public class HashTableTest {

    private static Hashtable<String, Object> table = new Hashtable<>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            table.put(String.valueOf(i), i);
        }
        for (Map.Entry<String, Object> entry : table.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
    }
}
