package demo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : jiang
 * @time : 2018/3/20 18:14
 */
public class TestMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("demo2.xml");
        PersonService personService = (PersonService) context.getBean("personService");
        personService.save("jiang");
    }
}
