package generics.wildcard;

import generics.Generics;

/**
 * @author : jiang
 * @time : 2018/5/14 18:40
 */
public class GenericDemo3 {
    public void showKeyValue(Generics<Number> obj) {
        System.out.println("The key`s value is: " + obj.getKey());
    }

    public static void main(String[] args) {
//        new GenericDemo3().showKeyValue(new Generics<>("xxx"));
        new GenericDemo3().showKeyValue(new Generics<>(111));
    }
}
