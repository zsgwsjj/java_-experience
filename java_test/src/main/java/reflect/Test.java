package reflect;

import java.lang.reflect.Method;

/**
 * @author : jiang
 * @time : 2018/4/13 14:03
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Class<?> clz = Class.forName("reflect.A");
        Object o = clz.newInstance();
        Method method = clz.getMethod("foo", String.class);
        for (int i = 0; ; i++) {
            method.invoke(o, Integer.toString(i));
            Thread.sleep(1000);
        }
    }
}

