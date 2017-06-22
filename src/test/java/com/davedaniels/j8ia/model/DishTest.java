package com.davedaniels.j8ia.model;

import com.google.common.truth.Truth;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by dave on 6/17/17.
 */
public class DishTest {

    @Test
    public void getNames() {
        List<Dish> menu = Arrays.asList(new Dish(300, "Zuchinie"), new Dish(600, "Pie"), new Dish(200, "Apple"));

        List<String> names = menu.parallelStream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());

        Truth.assertThat(names).isEqualTo(Arrays.asList("Apple", "Zuchinie"));
    }

    @Test
    public void collect() {
        List<Dish> menu = buildMenu();
        List<String> highc = menu.stream()
                .filter(d -> {
                    // limit operation short circuits, so only first three are printed
                    System.out.println("filtering " + d.getName());
                    return d.getCalories() > 300;

                })
                .map(d -> {
                    // if you run this, bother filtering and mapping are printed in the same pass despite being two separate operations
                    // this is known as "loop fusion"
                    System.out.println("mapping " + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(Collectors.toList());

        Truth.assertThat(highc).isEqualTo(Arrays.asList("pork", "beef", "chicken"));
    }

    private List<Dish> buildMenu() {
        return Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.MEAT),
                new Dish("rice", true, 350, Dish.Type.MEAT),
                new Dish("season fruit", true, 120, Dish.Type.MEAT),
                new Dish("pizza", true, 550, Dish.Type.MEAT),
                new Dish("prawns", false, 300, Dish.Type.MEAT),
                new Dish("salmon", false, 450, Dish.Type.MEAT));
    }
}