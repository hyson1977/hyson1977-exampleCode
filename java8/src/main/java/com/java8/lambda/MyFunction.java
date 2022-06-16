package com.java8.lambda;

@FunctionalInterface
public interface MyFunction<T, R> {
    public R getValue(T t1, T t2);
}
