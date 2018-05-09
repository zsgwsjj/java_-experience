package demo2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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

    @Around(value = "anyMethod()&& @annotation(aopTest)", argNames = "point,aopTest")
    public Object doAccessCheck(ProceedingJoinPoint point, AopTest aopTest) throws Throwable {
        System.out.println(aopTest.desc());
        System.out.println("前置通知");
        return point.proceed();
    }
}
