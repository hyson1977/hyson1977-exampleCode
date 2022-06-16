package com.java8.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStreamAPI2 {
    private final List<Employee> employees = new ArrayList<>();

    @Before
    public void setUp() {
        employees.add(new Employee("a1", 10, 500));
        employees.add(new Employee("b2", 20, 1000));
        employees.add(new Employee("c3", 30, 1500));
    }

    /*
    filter
    limit
    skip(n)
    distinct
     */
    @Test
    public void test1() {

        List<String> list = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        HashSet<String> list1 = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));

        //Collectors.summarizingDouble()


        Optional<Double> result = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        //result.get()

        //employees.removeIf();
        //Integer.compareUnsigned();

    }

}
