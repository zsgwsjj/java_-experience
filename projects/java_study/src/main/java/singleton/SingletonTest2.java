package singleton;

/**
 * @author : jiang
 * @time : 2018/5/9 17:29
 * 饿汉模式
 */
public class SingletonTest2 {

    private static SingletonTest2 singletonTest2 = new SingletonTest2();

    private SingletonTest2() {

    }

    public static SingletonTest2 getSingletonTest2() {
        return singletonTest2;
    }
}
