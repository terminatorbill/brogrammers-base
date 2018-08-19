package com.brogrammers;

import com.brogrammers.domain.Brogrammer;

public class Application {

    public static void main(String[] args) {

        Brogrammer
                .getBrogrammers()
                .forEach(brogrammer -> System.out.println("Hello " + brogrammer));
    }
}
