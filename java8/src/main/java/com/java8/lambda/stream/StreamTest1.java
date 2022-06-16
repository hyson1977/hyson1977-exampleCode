package com.java8.lambda.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest1 {
    public static void main(String[] args) {
        HashMap m = new HashMap(1000);
        char val[] = "value".toCharArray();
        for (char c : val) {
            System.out.println(c + 1);
        }
        //List<Integer> integerList = Arrays.asList(1, 1, 2, 3, 4, 5);
        //Stream<Integer> stream = integerList.stream().filter(i -> i > 3);
        List<String> wordList = Arrays.asList("Hello", "World");
        List<String> strList = wordList.stream()
                .map(w -> w.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(strList);

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        if (integerList.stream().anyMatch(i -> i > 3)) {
            System.out.println("值都大于3");
        }

        //List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        //Long result = integerList.stream().collect(counting());
        //System.out.println("result"+result);

        int sum = integerList.stream().reduce(0, (a, b) -> (a + b));
        System.out.println("sum" + sum);
        sum = integerList.stream().reduce(0, Integer::sum);

        //OptionalInt min = menu.stream().mapToInt(Dish::getCalories).min();
        //OptionalInt max = menu.stream().mapToInt(Dish::getCalories).max();

    }

}
