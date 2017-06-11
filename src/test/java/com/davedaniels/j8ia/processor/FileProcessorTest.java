package com.davedaniels.j8ia.processor;

import com.google.common.truth.Truth;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.BufferedReader;

@RunWith(JUnit4.class)
public class FileProcessorTest {

    @Test
    public void processFiles() throws Exception {
        String oneline = FileProcessor.processFile((BufferedReader br) -> br.readLine());
        String twoline = FileProcessor.processFile((BufferedReader br) -> br.readLine() + " " + br.readLine());

        Truth.assertThat(oneline).isEqualTo("first line");
        Truth.assertThat(twoline).isEqualTo("first line second line");
    }
}