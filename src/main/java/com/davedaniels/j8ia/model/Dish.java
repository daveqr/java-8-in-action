package com.davedaniels.j8ia.model;

/**
 * Created by dave on 6/17/17.
 */
public class Dish {
    private int calories;

    private String name;

    private String type;

    public Dish(int calories, String name) {
        this(calories, name, "Unknown");
    }

    public Dish(int calories, String name, String type) {
        this.calories = calories;
        this.name = name;
        this.type = type;
    }

    public int getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
