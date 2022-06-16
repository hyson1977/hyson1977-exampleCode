package com.example;

import com.example.annotation.MethodExporter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class MethodExporterAspect {

//    @Before(value = "@annotation(com.example.annotation.MethodExporter)")
//    public void before(MethodExporter m) {
//        System.out.println(m.value());
//    }

    @Around("@annotation(com.example.annotation.MethodExporter)")
    public Object methodExporter(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed=joinPoint.proceed(joinPoint.getArgs());
        //System.out.println(Arrays.deepToString(joinPoint.getThis().getClass().getMethod("list").getAnnotation()));
        System.out.println(joinPoint.getThis().getClass().getMethod("list").getAnnotation(MethodExporter.class));
        //System.out.println(joinPoint.getThis().getClass().getMethod("list").getDeclaredAnnotations());
        System.out.println(joinPoint.getTarget().getClass().getSimpleName());
        System.out.println(joinPoint.getSignature().getName());
        System.out.println(proceed);
        System.out.println(proceed.getClass().getAnnotation(MethodExporter.class));

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        if (method != null)
        {
            MethodExporter apiLog=  method.getAnnotation(MethodExporter.class);
            System.out.println("切入方法注解的value:"+apiLog.value());
        }
        return proceed;
    }
}
