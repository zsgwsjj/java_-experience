package singleton;

/**
 * @author : jiang
 * @time : 2018/5/9 16:54
 * 懒汉模式
 */
public class SingletonTest {
    private static SingletonTest singletonTest = null;

    private SingletonTest() {

    }

    public static synchronized SingletonTest getSingletonTest() {
        if (singletonTest == null) {
            singletonTest = new SingletonTest();
        }
        return singletonTest;
    }
}

