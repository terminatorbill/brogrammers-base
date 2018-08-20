package com.brogrammers.domain;

import java.util.regex.Pattern;

public class BrogrammerValidNameFilter implements BrogrammerFilter {

    private final Pattern pattern;

    public BrogrammerValidNameFilter() {
        pattern = Pattern.compile("[a-zA-Z]{3,25}");
    }

    @Override
    public boolean shouldKeep(Brogrammer brogrammer) {
        return pattern.matcher(brogrammer.toString()).matches();
    }
}
