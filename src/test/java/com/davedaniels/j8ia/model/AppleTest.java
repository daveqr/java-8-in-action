package com.davedaniels.j8ia.model;

import com.davedaniels.j8ia.Main;
import com.google.common.truth.Truth;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RunWith(JUnit4.class)
public class AppleTest {

    @Test
    public void testSort() {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(5, "green"));
        inventory.add(new Apple(2, "red"));
        inventory.add(new Apple(77, "yellow"));

        Main main = new Main();
        main.appleSort(inventory);

        for (Apple apple : inventory) {
            System.out.println(apple.getWeight());
        }
    }

    @Test
    public void sortUsingLambdaComparator() {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(5, "green"));
        inventory.add(new Apple(155, "green"));
        inventory.add(new Apple(2, "red"));
        inventory.add(new Apple(77, "yellow"));

        List<Apple> inventory2 = new ArrayList<>();
        inventory2.addAll(inventory);

        Comparator<Apple> byWeight = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        inventory2.sort(byWeight);
        Truth.assertThat(inventory2.get(0)).isEqualTo(inventory.get(2));
        Truth.assertThat(inventory2.get(1)).isEqualTo(inventory.get(0));
        Truth.assertThat(inventory2.get(2)).isEqualTo(inventory.get(3));
        Truth.assertThat(inventory2.get(3)).isEqualTo(inventory.get(1));
    }

    @Test
    public void filterGreenApples() {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(5, "green"));
        inventory.add(new Apple(155, "green"));
        inventory.add(new Apple(2, "red"));
        inventory.add(new Apple(77, "yellow"));

        List<Apple> actual = Apple.filterGreenApples(inventory);
        List<Apple> actualWithPred = Apple.filterApples(inventory, Apple::isGreenApple);
        List<Apple> actualWithLambda = Apple.filterApples(inventory, (Apple a) -> "green".equals((a.getColor())));


        List<Apple> expected = new ArrayList<>();
        expected.add(inventory.get(0));
        expected.add(inventory.get(1));

        Truth.assertThat(actual).isEqualTo(expected);
        Truth.assertThat(actual).isEqualTo(actualWithPred);
        Truth.assertThat(actual).isEqualTo(actualWithLambda);
    }

    @Test
    public void filterHeavyApples() {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(5, "green"));
        inventory.add(new Apple(155, "green"));
        inventory.add(new Apple(2, "red"));
        inventory.add(new Apple(77, "yellow"));
        inventory.add(new Apple(200, "yellow"));

        List<Apple> actual = Apple.filterHeavyApples(inventory);
        List<Apple> actualWithMethodRef = Apple.filterApples(inventory, Apple::isHeavyApple);
        List<Apple> actualWithLambda = Apple.filterApples(inventory, (Apple a) -> a.getWeight() > 150);

        List<Apple> expected = new ArrayList<>();
        expected.add(inventory.get(1));
        expected.add(inventory.get(4));

        Truth.assertThat(actual).isEqualTo(expected);
        Truth.assertThat(actual).isEqualTo(actualWithMethodRef);
        Truth.assertThat(actual).isEqualTo(actualWithLambda);
    }
}