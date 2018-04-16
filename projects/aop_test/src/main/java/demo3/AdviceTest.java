package demo3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;

import java.util.Arrays;

/**
 * @author : jiang
 * @time : 2018/3/20 18:18
 */
public class AdviceTest {

    @Around("execution(* demo3.*.many*(..)")
    public Object process(ProceedingJoinPoint point) throws Throwable {
        System.out.println("@Around: begin method");
        Object[] args = point.getArgs();
        if (args != null && args.length > 0 && args[0].getClass() == String.class) {
            args[0] = "changed param 1";
        }
        Object returnValue = point.proceed(args);
        System.out.println("@Around: after do target method ");
        System.out.println("@Around: be doing class is: " + point.getTarget());
        return "quondam value: " + returnValue + ", this is return value`s postfix";
    }

    public void permissionCheck(JoinPoint point) {
        System.out.println("@Before: permission check...");
        System.out.println("@Before: target method: " + point.getSignature().getDeclaringTypeName() + "." +
                point.getSignature().getName());
        System.out.println("@Before: params : " + Arrays.toString(point.getArgs()));
        System.out.println("@Before: be doing class is: " + point.getTarget());
    }

    @AfterReturning(pointcut = "execution(* demo3.)")
    public void log(JoinPoint point, Object returnValue) {
        System.out.println("@AfterReturning: log...");
        System.out.println("@AfterReturning: target method: " + point.getSignature().getDeclaringTypeName() + "." +
                point.getSignature().getName());
        System.out.println("@AfterReturning: params: " + Arrays.toString(point.getArgs()));
        System.out.println("@AfterReturning: return value: " + returnValue);
        System.out.println("@AfterReturning: be doing class is: " + point.getTarget());
    }

    public void releaseResource(JoinPoint point) {
        System.out.println("@After: release resource...");
        System.out.println("@After: target method: " + point.getSignature().getDeclaringTypeName() + "." +
                point.getSignature().getName());
        System.out.println("@After: params: " + Arrays.toString(point.getArgs()));
        System.out.println("@After: be doing class is: "+point.getTarget());
    }
}
