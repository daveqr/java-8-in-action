package com.davedaniels.j8ia;/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import com.davedaniels.j8ia.model.Apple;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class MainTest {

    @Test
    public void testSort() {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(5));
        inventory.add(new Apple(2));
        inventory.add(new Apple(77));

        Main main = new Main();
        main.appleSort(inventory);

        for (Apple apple : inventory
                ) {
            System.out.println(apple.getWeight());
        }
    }
}