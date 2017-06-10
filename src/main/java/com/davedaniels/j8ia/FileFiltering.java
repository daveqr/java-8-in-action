package com.davedaniels.j8ia;


import java.io.File;
import java.io.FileFilter;

public class FileFiltering {

    public File[] findHiddenFilesOld() {
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });

        return hiddenFiles;
    }

    public File[] findHiddenFiles() {
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);

        return hiddenFiles;
    }
}
