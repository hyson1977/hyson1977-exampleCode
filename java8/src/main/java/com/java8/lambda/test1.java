package com.java8.lambda;

import java.util.*;
import java.util.function.Predicate;

public class test1 {
    private List<Employee> employees = new ArrayList<>();

    {
        employees.add(new Employee("a1", 10, 500));
        employees.add(new Employee("b2", 20, 1000));
        employees.add(new Employee("c3", 30, 1500));
    }

    public static void main(String[] args) {
        test1 t = new test1();
        t.test6();
    }

    void test6() {
        Map map = new HashMap<>();
        Optional<String> userName = Optional.of("xjjdog");
        String defaultEmail = userName
                .map(e -> e + "@xjjdog.cn")
                .orElse("");

        List<Employee> list = filterEmployee(employees, (e) -> e.getSalary() >= 1000);
        list.forEach(System.out::println);
        employees.stream()
                .filter((e) -> e.getSalary() >= 1000)
                .limit(2)
                .forEach(System.out::println);
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

    }

    public List<Employee> filterEmployee(List<Employee> list, Predicate<Employee> mp) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if (mp.test(employee)) {
                emps.add(employee);
            }
        }
        return emps;
    }

}
