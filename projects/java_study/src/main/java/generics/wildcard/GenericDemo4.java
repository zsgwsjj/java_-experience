package generics.wildcard;

import generics.Generics;

/**
 * @author : jiang
 * @time : 2018/5/14 18:40
 */
public class GenericDemo4 {
    public void showKeyValue(Generics<?> obj) {
        System.out.println("The key`s value is: " + obj.getKey());
    }

    public static void main(String[] args) {
        new GenericDemo4().showKeyValue(new Generics<>("xxx"));
    }
}
