package com.brogrammers.domain;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Brogrammer {

    private static List<Brogrammer> brogrammers;

    static {
        try {
            Properties sample = new Properties();
            sample.load(new FileReader("src/main/resources/sample.properties"));

            brogrammers = Arrays.stream(sample.getProperty("brogrammers").split(","))
                    .map(Brogrammer::new)
                    .collect(Collectors.toList());

        } catch (Exception error) {
            throw new IllegalStateException(error);
        }
    }

    public static List<Brogrammer> getBrogrammers() {
        return brogrammers;
    }

    private final String name;

    private Brogrammer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
