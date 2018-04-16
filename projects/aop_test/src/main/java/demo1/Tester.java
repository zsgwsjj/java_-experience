package demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : jiang
 * @time : 2018/3/20 17:51
 */
public class Tester {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");

        HelloWorld hw1 = (HelloWorld) context.getBean("helloWorld1");
        HelloWorld hw2 = (HelloWorld) context.getBean("helloWorld2");

        hw1.printHelloWorld();
        System.out.println();
        hw1.doPrint();
        System.out.println();
        hw2.printHelloWorld();
        System.out.println();
        hw2.doPrint();
    }
}
