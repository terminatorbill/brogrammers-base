package com.brogrammers.domain;

public class Brogrammer {

    private final String name;

    Brogrammer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
