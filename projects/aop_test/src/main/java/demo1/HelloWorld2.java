package demo1;

/**
 * @author : jiang
 * @time : 2018/3/20 17:45
 */
public class HelloWorld2 implements HelloWorld {
    @Override
    public void printHelloWorld() {
        System.out.println("do2");
    }

    @Override
    public void doPrint() {
        System.out.println("do print2");
    }
}
