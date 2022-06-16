package com.java8.lambda;

import java.util.Objects;

public class Dish {
    private String name;
    private boolean vegetarian;
    private int calories;
    private String type;

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        Dish dish = (Dish) o;
        return isVegetarian() == dish.isVegetarian() && getCalories() == dish.getCalories() && getName().equals(dish.getName()) && getType().equals(dish.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), isVegetarian(), getCalories(), getType());
    }
    // getter and setter
}
