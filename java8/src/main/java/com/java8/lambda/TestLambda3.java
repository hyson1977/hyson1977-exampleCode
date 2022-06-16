package com.java8.lambda;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

@SpringBootTest
public class TestLambda3 {
    private final List<Employee> employees = new ArrayList<>();

    @Before
    public void setUp() {
        employees.add(new Employee("a1", 10, 500));
        employees.add(new Employee("b2", 20, 1000));
        employees.add(new Employee("c3", 30, 1500));
    }

    //Consumer<T>
    @Test
    public void test1() {
        Consumer<String> con = (x) -> System.out.println(x);
        Employee emp = new Employee("test", 20, 300);
        Supplier<String> sup = () -> emp.getName();
        String str = sup.get();
        System.out.println(str);

        Supplier<Integer> sup2 = emp::getAge;
        Integer num = sup2.get();
        System.out.println(num);

    }

    @Test
    public void test2() {
        Comparator<Integer> com = Integer::compare;
        //Collections.sort(employees,Integer::compare);
    }

    @Test
    public void test3() {
        BiPredicate<String, String> bp = String::equals;
        Supplier<Employee> sup = Employee::new;
        Function<Integer, Employee> fun = Employee::new;
        Employee emp = fun.apply(101);
        System.out.println(emp);
        BiFunction<Integer, String, Employee> fun1 = Employee::new;

        Employee emp1 = fun1.apply(101, "test");
        System.out.println(emp1);

        Function<Integer, String[]> fun2 = (x) -> new String[x];
        String[] strs = fun2.apply(10);
        System.out.println(strs.length);
        Function<Integer, String[]> fun3 = String[]::new;
        String[] strs1 = fun3.apply(20);
        System.out.println(strs1.length);


    }


}
