package com.davedaniels.j8ia.model;

import com.google.common.truth.Truth;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by dave on 6/14/17.
 */
public class AppleComparatorTest {

    @Test
    public void sortUsingComparator() {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(5, "green"));
        inventory.add(new Apple(155, "green"));
        inventory.add(new Apple(2, "red"));
        inventory.add(new Apple(77, "yellow"));

        List<Apple> inventory2 = new ArrayList<>();
        inventory2.addAll(inventory);

        inventory2.sort(Comparator.comparing(Apple::getWeight));

        Truth.assertThat(inventory2.get(0)).isEqualTo(inventory.get(2));
        Truth.assertThat(inventory2.get(1)).isEqualTo(inventory.get(0));
        Truth.assertThat(inventory2.get(2)).isEqualTo(inventory.get(3));
        Truth.assertThat(inventory2.get(3)).isEqualTo(inventory.get(1));
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
}