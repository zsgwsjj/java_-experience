package generics.interfacee;

/**
 * @author : jiang
 * @time : 2018/5/14 18:08
 */
public class GeneratorImpl<T> implements Generator<T> {
    @Override
    public T get() {
        return (T) "xxx";
    }

    public static void main(String[] args) {
        System.out.println(new GeneratorImpl<>().get());
    }
}
