package com.davedaniels.j8ia.processor;

import java.io.*;

public class FileProcessor {

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(FileProcessor.class.getResourceAsStream("/data.txt")))) {
            return p.process(br);
        }
    }
}
