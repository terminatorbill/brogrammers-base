package com.brogrammers.it;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

import org.junit.Test;

import com.brogrammers.domain.Brogrammer;
import com.brogrammers.domain.BrogrammerFilter;
import com.brogrammers.domain.BrogrammerRegistry;
import com.brogrammers.domain.BrogrammerValidNameFilter;

public class BrogrammerRegistryIT {

    @Test
    public void should_return_the_real_brogrammers() {
        //given
        Properties sample = getProperties();
        BrogrammerFilter brogrammerFilter = new BrogrammerValidNameFilter(Pattern.compile("[a-zA-Z]{3,25}"));
        BrogrammerRegistry brogrammerRegistry = new BrogrammerRegistry(brogrammerFilter, sample);

        // when
        List<Brogrammer> realBrogrammers = brogrammerRegistry.getBrogrammers();

        // then
        assertThat(realBrogrammers.size(), is(2));
        assertThat(realBrogrammers.get(0).toString(), is("BillSoum"));
        assertThat(realBrogrammers.get(1).toString(), is("Chriniko"));
    }

    private Properties getProperties() {
        try {
            Properties properties = new Properties();
            properties.load(this.getClass().getClassLoader().getResourceAsStream("sample.properties"));
            return properties;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
