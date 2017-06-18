package com.davedaniels.j8ia;

import com.google.common.truth.Truth;
import org.junit.Test;

import java.util.function.Function;

/**
 * Created by dave on 6/17/17.
 */
public class LetterTest {

    @Test
    public void transform() {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> a = addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);
        Function<String, String> b = addHeader.andThen(Letter::addFooter);

        String body = "This is the labda body";

        Truth.assertThat(a.apply(body)).isEqualTo("From Raoul, Mario and Alan: This is the lambda body Kind regards");
        Truth.assertThat(b.apply(body)).isEqualTo("From Raoul, Mario and Alan: This is the labda body Kind regards");
    }
}