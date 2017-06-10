package com.davedaniels.j8ia;

import com.google.common.truth.Truth;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;

@RunWith(JUnit4.class)
public class FileFilteringTest {

    @Test
    public void findHiddenFiles() {
        FileFiltering ff = new FileFiltering();
        File[] hiddenFiles = ff.findHiddenFiles();
        File[] hiddenFilesOld = ff.findHiddenFilesOld();

        Truth.assertThat(hiddenFiles).isNotEmpty();
        Truth.assertThat(hiddenFiles).isEqualTo(hiddenFilesOld);
    }
}