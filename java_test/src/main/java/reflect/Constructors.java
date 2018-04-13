package reflect;

import java.lang.reflect.Constructor;

/**
 * @author : jiang
 * @time : 2018/4/13 11:02
 */
public class Constructors {

    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("reflect.Student");
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("*****************获取公有、无参的构造方法*******************************");
        Constructor constructor = clazz.getConstructor(null);
        System.out.println(constructor);
        Object object = constructor.newInstance();

        System.out.println("******************获取私有构造方法，并调用*******************************");
        constructor = clazz.getDeclaredConstructor(char.class);
        System.out.println(constructor);
        object = constructor.newInstance('x');
    }
}

