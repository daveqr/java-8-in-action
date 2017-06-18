package com.davedaniels.j8ia.model;

import com.google.common.truth.Truth;
import org.junit.Test;

import java.util.function.Function;

/**
 * Created by dave on 6/14/17.
 */
public class ComposingFunctionsTest {

    @Test
    public void andThenCompose() {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;

        Function<Integer, Integer> h = f.andThen(g);
        Function<Integer, Integer> i = g.andThen(f);
        Truth.assertThat(h.apply(1)).isEqualTo(4);
        Truth.assertThat(i.apply(1)).isEqualTo(3);

        Function<Integer, Integer> j = f.compose(g);
        Function<Integer, Integer> k = g.compose(f);
        Truth.assertThat(j.apply(1)).isEqualTo(3);
        Truth.assertThat(k.apply(1)).isEqualTo(4);
    }
}
