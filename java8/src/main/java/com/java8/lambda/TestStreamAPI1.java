package com.java8.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStreamAPI1 {
    @Before
    public void setUp() {
    }

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.forEach(System.out::println);

        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::print);


    }

}
