package weakReference;


import java.util.WeakHashMap;

/**
 * @author : jiang
 * @time : 2018/4/19 11:08
 */
public class WeakHashMapTest {

    public static void main(String[] args) {
        WeakHashMap w = new WeakHashMap();
        w.put(new String("语文"), new String("1"));
        w.put(new String("数学"), new String("2"));
        w.put(new String("英语"), new String("3"));
        w.put("体育", new String("4"));
        System.out.println(w);
        System.gc();
        System.runFinalization();
        System.out.println("second" + w);
    }
}
