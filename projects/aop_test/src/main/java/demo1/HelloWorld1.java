package demo1;

/**
 * @author : jiang
 * @time : 2018/3/20 17:44
 */
public class HelloWorld1 implements HelloWorld {
    @Override
    public void printHelloWorld() {
        System.out.println("do1");
    }

    @Override
    public void doPrint() {
        System.out.println("do print1");
    }
}
