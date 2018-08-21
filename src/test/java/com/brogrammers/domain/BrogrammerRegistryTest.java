package com.brogrammers.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Properties;

import org.junit.Test;

public class BrogrammerRegistryTest {

    @Test
    public void getBrogrammers() {

        // given
        Properties properties = mock(Properties.class);
        when(properties.getProperty("brogrammers")).thenReturn("Chriniko,SoumBill");

        BrogrammerFilter brogrammerFilter = record -> true;
        BrogrammerRegistry brogrammerRegistry = new BrogrammerRegistry(brogrammerFilter, properties);

        // when
        List<Brogrammer> brogrammers = brogrammerRegistry.getBrogrammers();

        // then
        assertThat(brogrammers.size(), is(2));
    }
}