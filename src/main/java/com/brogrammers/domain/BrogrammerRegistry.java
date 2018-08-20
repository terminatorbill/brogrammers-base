package com.brogrammers.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class BrogrammerRegistry {

    private final List<Brogrammer> brogrammers;

    public BrogrammerRegistry(BrogrammerFilter brogrammerFilter, Properties properties) {
            brogrammers = Arrays.stream(properties.getProperty("brogrammers").split(","))
                    .map(Brogrammer::new)
                    .filter(brogrammerFilter::shouldKeep)
                    .collect(Collectors.toList());
    }

    public List<Brogrammer> getBrogrammers() {
        return brogrammers;
    }
}
