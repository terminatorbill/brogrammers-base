package com.brogrammers.domain;

@FunctionalInterface
public interface BrogrammerFilter {

    boolean shouldKeep(Brogrammer brogrammer);
}
