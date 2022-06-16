package com.java8.lambda;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

@SpringBootTest
public class TestLambda2 {
    private final List<Employee> employees = new ArrayList<>();

    @Before
    public void setUp() {

        employees.add(new Employee("a1", 10, 500));
        employees.add(new Employee("b2", 20, 1000));
        employees.add(new Employee("c3", 30, 1500));

    }

    @Test
    public void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello1");
            }
        };
        r.run();
        Runnable r1 = () -> System.out.println("Hello");
        r1.run();
    }

    @Test
    public void test2() {
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("test");
    }

    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("fun interface");
            return Integer.compare(x, y);
        };
    }

    @Test
    public void test4() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }

    @Test
    public void test5() {
        //Comparator<Integer> com=(x,y)->Integer.compare(x,y);
        Integer result = operation(100, (x) -> x * x);
        System.out.println(result);
    }

    public Integer operation(Integer num, MyFun mf) {
        return mf.getValue(num);
    }

    @Test
    public void testSort() {
        Collections.sort(employees, (e1, e2) -> {
                    return e1.getName().compareTo(e2.getName());
                }
        );
    }

    @Test
    public void testOp() {
        op(100l, 200l, (x, y) -> x + y);
        op(100l, 200l, (x, y) -> x * y);
    }

    public void op(Long l1, Long l2, MyFunction<Long, Long> mf) {
        System.out.println(mf.getValue(l1, l2));
    }

}
