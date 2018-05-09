package weakReference;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * @author : jiang
 * @time : 2018/4/19 10:55
 */
public class Test {

    public static void main(String[] args) {
        String a = "a";
        WeakReference<String> b = new WeakReference<>(a);
        WeakHashMap<String, Integer> weakMap = new WeakHashMap<>();
        weakMap.put(b.get(), 1);
        a = null;
        System.gc();
        String c = "";
        try {
            c = b.get().replace("a", "b");
            System.out.println(c);
        } catch (Exception e) {
            c = "c";
            System.out.println(c);
        } finally {
            c += "d";
            System.out.println(c + "e");
        }
    }
}
