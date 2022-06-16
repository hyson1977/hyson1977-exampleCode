package com.java8.lambda.test;

import java.util.SortedSet;
import java.util.TreeSet;

public class SalesInvoice extends Invoice {
    public static String a(String a) {
        return a + "_Salesinvoice";
    }

    public static void main(String[] args) throws Exception {
        Invoice invoice = new SalesInvoice();
        System.out.println(invoice.a("1234"));

        SortedSet<Element> s = new TreeSet<>();
        s.add(new Element(15));
        s.add(new Element(10));
        s.add(new Element(25));
        s.add(new Element(10));
        System.out.println(s.first() + "" + s.size());
    }

}
