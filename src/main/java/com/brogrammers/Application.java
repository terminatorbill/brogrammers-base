package com.brogrammers;

import java.util.Properties;
import java.util.regex.Pattern;

import com.brogrammers.domain.BrogrammerFilter;
import com.brogrammers.domain.BrogrammerRegistry;
import com.brogrammers.domain.BrogrammerValidNameFilter;

public class Application {

    public static void main(String[] args) {

        BrogrammerFilter brogrammerFilter = new BrogrammerValidNameFilter(Pattern.compile("[a-zA-Z]{3,25}"));
        Properties sample = loadProperties();

        BrogrammerRegistry brogrammerRegistry = new BrogrammerRegistry(brogrammerFilter, sample);

        brogrammerRegistry
                .getBrogrammers()
                .forEach(brogrammer -> System.out.println("Hello " + brogrammer + "!"));
    }

    private static Properties loadProperties() {
        Properties sample = new Properties();
        try {
            sample.load(Application.class.getClassLoader().getResourceAsStream("sample.properties"));
            return sample;
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }
}
