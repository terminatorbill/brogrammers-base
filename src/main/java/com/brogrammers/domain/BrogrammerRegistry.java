package com.brogrammers.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class BrogrammerRegistry {

    private static final String FILE_NAME = "sample.properties";

    private final List<Brogrammer> brogrammers;

    public BrogrammerRegistry(BrogrammerFilter brogrammerFilter) {
        try {
            Properties sample = new Properties();
            sample.load(this.getClass().getClassLoader().getResourceAsStream(FILE_NAME));

            brogrammers = Arrays.stream(sample.getProperty("brogrammers").split(","))
                    .map(Brogrammer::new)
                    .filter(brogrammerFilter::shouldKeep)
                    .collect(Collectors.toList());

        } catch (Exception error) {
            throw new IllegalStateException(error);
        }
    }

    public List<Brogrammer> getBrogrammers() {
        return brogrammers;
    }
}
