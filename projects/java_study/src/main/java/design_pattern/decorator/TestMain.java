package design_pattern.decorator;

public class TestMain {

    public static void main(String[] args) {
        new TestDecoratorImpl(new TestImpl()).doPrint();
    }
}
