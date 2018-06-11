package design_pattern.decorator;

public class TestDecoratorImpl implements Test {

    private Test test;

    public TestDecoratorImpl(Test test) {
        this.test = test;
    }

    @Override
    public void doPrint() {
        test.doPrint();
        System.out.println("this is a new impl");
    }
}
