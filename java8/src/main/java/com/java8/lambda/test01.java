package com.java8.lambda;

public class test01 {

    public static void main(String[] args) {
        //
        String str1 = new StringBuilder("hello").append("World").toString();
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());

        String str3 = new StringBuilder("hello").toString();
        System.out.println(str3.intern());
        System.out.println(str3 == str3.intern());
        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));
        System.out.println(System.identityHashCode(str3));

    }
}
