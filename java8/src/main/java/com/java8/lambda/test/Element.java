package com.java8.lambda.test;

public class Element implements Comparable {
    int id;

    Element(int id) {
        this.id = id;
    }

    public int compareTo(Object obj) {
        Element e = (Element) obj;
        return this.id - e.id;

    }

    public String toString() {
        return "" + this.id;
    }

}
