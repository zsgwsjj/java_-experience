package generics.clazz;

import generics.Generics;

/**
 * @author : jiang
 * @time : 2018/5/14 17:13
 */
public class GenericsClass {

    public static void main(String[] args) {
        new GenericsClass().doTest2();
    }

    private void doTest1() {
        Generics<String> stringGenerics = new Generics<>("jiang");
        Generics<Integer> integerGenerics = new Generics<>(11111);

        System.out.println(stringGenerics.getKey());
        System.out.println(integerGenerics.getKey());
    }

    private void doTest2() {
        Generics generics1 = new Generics(123456);
        Generics generics2 = new Generics("jiang");
        Generics generics3 = new Generics(44.55);

        System.out.println(generics1.getKey());
        System.out.println(generics2.getKey());
        System.out.println(generics3.getKey());
    }

}

