package com.brogrammers;

import java.util.regex.Pattern;

import com.brogrammers.domain.BrogrammerFilter;
import com.brogrammers.domain.BrogrammerRegistry;
import com.brogrammers.domain.BrogrammerValidNameFilter;

public class Application {

    public static void main(String[] args) {

        BrogrammerFilter brogrammerFilter = new BrogrammerValidNameFilter(Pattern.compile("[a-zA-Z]{3,25}"));

        BrogrammerRegistry brogrammerRegistry = new BrogrammerRegistry(brogrammerFilter);

        brogrammerRegistry
                .getBrogrammers()
                .forEach(brogrammer -> System.out.println("Hello " + brogrammer + "!"));
    }
}
