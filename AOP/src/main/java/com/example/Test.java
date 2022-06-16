package com.example;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

public class Test {
    public static void main(String[] args) {
        UserService target = new UserService();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                System.out.println("before ...");

                Object result = methodInvocation.proceed();
                System.out.println("after ...");
                return result;
            }
        });
        UserInterface userService = (UserInterface) proxyFactory.getProxy();
        userService.test();

    }
}
