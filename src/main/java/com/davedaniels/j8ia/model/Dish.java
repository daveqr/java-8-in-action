package com.davedaniels.j8ia.model;

/**
 * Created by dave on 6/17/17.
 */
public class Dish {
    private int calories;

    private boolean vegetarian;

    private String name;

    private Type type;

    public Dish(int calories, String name) {
        this(name, false, calories, Type.OTHER);
    }

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public enum Type {MEAT, FISH, OTHER}
}
