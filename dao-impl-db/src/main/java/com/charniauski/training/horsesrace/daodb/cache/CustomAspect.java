package com.charniauski.training.horsesrace.daodb.cache;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class CustomAspect {


    @Around(value = "execution( * com.charniauski.training.horsesrace.daodb.*.get*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("joinPoint.getArgs()= " + Arrays.toString(joinPoint.getArgs()));
//        System.out.println("joinPoint.getArgs()= "+joinPoint.getArgs()[0].toString());
//        Object o = joinPoint.getArgs()[0];
//        Class<?> aClass = o.getClass();
//        System.out.println(aClass.getName());
//        System.out.println(aClass.getSimpleName());
        System.out.println("joinPoint.getSignature()= " + joinPoint.getSignature());
        System.out.println("joinPoint.toLongString()= " + joinPoint.toLongString());
        System.out.println("joinPoint.getKind()= " + joinPoint.getKind());
        String kind = joinPoint.getKind();
        System.out.println("kind= " + kind);
        System.out.println("joinPoint.getSourceLocation()= " + joinPoint.getSourceLocation());
        System.out.println("joinPoint.toShortString()= " + joinPoint.toShortString());
        System.out.println("joinPoint.getStaticPart()= " + joinPoint.getStaticPart());
        System.out.println("joinPoint.getTarget()= " + joinPoint.getTarget());
        System.out.println("joinPoint.getThis()= " + joinPoint.getThis());
        Object proceed = joinPoint.proceed();

        System.out.println("joinPoint.getThis()= " + proceed);


        return proceed;
    }

    //    https://github.com/dwatrous/cache4guice/blob/master/src/main/java/com/hp/cache4guice/aop/CacheInterceptor.java
    @After("execution(* com.charniauski.training.horsesrace.daodb.*.get*(..))")
    public void logAfter(JoinPoint joinPoint) {

        System.out.println("logAfter() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");

    }


    @AfterReturning(pointcut = "@annotation(Cached)&& execution(* com.charniauski.training.horsesrace.daodb.*.get*(..)))",
            returning = "result")
    public Object logAfterReturning(JoinPoint joinPoint, Object result) {

        System.out.println("logAfterReturning() is running!");
//        System.out.println(Arrays.toString(joinPoint.getArgs()));
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is : " + result);
        System.out.println("******");


        return result;
    }


}