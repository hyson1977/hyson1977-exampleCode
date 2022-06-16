package com.java8.lambda.optional;

import com.java8.lambda.pojo.Address;
import com.java8.lambda.pojo.Person;

import java.util.Optional;

public class Test1 {
    public String getCity(Person user) throws Exception {
        if (user != null) {
            if (user.getAddress() != null) {
                Address address = user.getAddress();
                if (address.getCity() != null) {
                    return address.getCity();
                }
            }
        }
        throw new Exception("取值错误");
    }

    public Person getUser(Person user) throws Exception {
        if (user != null) {
            String name = user.getName();
            if ("zhangsan".equals(name)) {
                return user;
            }
        } else {
            user = new Person();
            user.setName("zhangsan");
            return user;
        }
        return null;
    }

    public Person getUser1(Person user) {
        return Optional.ofNullable(user)
                .filter(u -> "zhangsan".equals(u.getName()))
                .orElseGet(() -> {
                    Person user1 = new Person();
                    user1.setName("zhangsan");
                    return user1;
                });
    }

    public String getCity1(Person user) throws Exception {
        return Optional.ofNullable(user)
                .map(u -> u.getAddress())
                .map(a -> a.getCity())
                .orElseThrow(() -> new Exception("取指错误"));
    }

    public void test2() {
        Person user = new Person();
        Optional.ofNullable(user)
                .ifPresent(u -> {
                    System.out.println(u.getName());
                });

    }

}
