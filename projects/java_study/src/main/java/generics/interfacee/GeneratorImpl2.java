package generics.interfacee;

/**
 * @author : jiang
 * @time : 2018/5/14 18:33
 */
public class GeneratorImpl2 implements Generator<String> {
    @Override
    public String get() {
        return "jiang";
    }

    public static void main(String[] args) {
        System.out.println(new GeneratorImpl2().get());
    }
}
