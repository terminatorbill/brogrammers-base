package com.brogrammers.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BrogrammerValidNameFilterTest {

    private final BrogrammerFilter brogrammerFilter = new BrogrammerValidNameFilter(Pattern.compile("[a-zA-Z]{3,25}"));
    private final String brogrammerName;
    private final boolean isValid;

    public BrogrammerValidNameFilterTest(String brogrammerName, boolean isValid) {
        this.brogrammerName = brogrammerName;
        this.isValid = isValid;
    }

    @Test
    public void should_filter_brogrammers_adhering_to_pattern() {

        // given
        Brogrammer brogrammer = new Brogrammer(brogrammerName);

        // when
        boolean shouldKeep = brogrammerFilter.shouldKeep(brogrammer);

        // then
        assertThat(shouldKeep, is(isValid));
    }


    @Parameterized.Parameters
    public static Collection<Object[]> createBrogrammerNames() {
        return Arrays.asList(new Object[][] {
                {"SoumBill", true},
                {"ChriNikos", true},
                {"Someone123", false},
                {"aiaosdkaopidoaisoaidoaidoapsidopasidopasido", false},
                {"a", false}
        });
    }
}