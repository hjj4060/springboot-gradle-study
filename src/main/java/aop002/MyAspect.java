package aop002;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
    @Pointcut("execution(* runSomething())")
    private void iampc() {}

    @Before("iampc()")
    public void before(JoinPoint joinPoint) {
        System.out.println("얼굴 인식 확인: 문을 개방하라");
    }

    @After("iampc()")
    public void after(JoinPoint joinPoint) {
        System.out.println("주인님 나갔다: 어이 문 잠가!!!");
    }

    /*@Before("execution(* runSomething())")
    public void before(JoinPoint joinPoint) {
        System.out.println("얼굴 인식 확인: 문을 개방하라");
    }

    @After("execution(* runSomething())")
    public void after(JoinPoint joinPoint) {
        System.out.println("주인님 나갔다: 어이 문 잠가!!!");
    }*/
}
