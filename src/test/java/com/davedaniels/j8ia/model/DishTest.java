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
        List<Dish> menu = Arrays.asList(new Dish(300, "Zuchinie", "veggie"), new Dish(600, "Pie", "dessert"), new Dish(200, "Apple", "veggie"));

        Map<String, List<Dish>> dishesByType = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));

        Map<String, List<Dish>> expected = new HashMap<>();
        expected.put("veggie", Arrays.asList(menu.get(0), menu.get(2)));
        expected.put("dessert", Arrays.asList(menu.get(1)));

        Truth.assertThat(dishesByType).isEqualTo(expected);
    }
}