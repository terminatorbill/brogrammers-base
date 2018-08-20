package com.brogrammers.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.List;

import org.junit.jupiter.api.Test;

public class BrogrammerRegistryTest {

    @Test
    public void getBrogrammers() {

        // given
        BrogrammerFilter brogrammerFilter = record -> true;
        BrogrammerRegistry brogrammerRegistry = new BrogrammerRegistry(brogrammerFilter);

        // when
        List<Brogrammer> brogrammers = brogrammerRegistry.getBrogrammers();

        // then
        assertThat(brogrammers.size(), is(8));
    }
}