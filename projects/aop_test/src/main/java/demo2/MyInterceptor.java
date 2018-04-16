package demo2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author : jiang
 * @time : 2018/3/20 18:07
 */
@Aspect
public class MyInterceptor {

    @Pointcut("@annotation(AopTest)")
    private void anyMethod() {

    }

    @Before("anyMethod()")
    public void doAccessCheck() {
        System.out.println("前置通知");
    }
}
