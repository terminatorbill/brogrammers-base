package com.brogrammers.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BrogrammerValidNameFilterTest {

    private final BrogrammerFilter brogrammerFilter = new BrogrammerValidNameFilter(Pattern.compile("[a-zA-Z]{3,25}"));

    @DisplayName("Should allow brogrammer names which adhere to the provided Pattern")
    @ParameterizedTest
    @MethodSource("createBrogrammerNames")
    void shouldKeep(String brogrammerName, boolean isValid) {

        // given
            Brogrammer brogrammer = new Brogrammer(brogrammerName);

        // when
        boolean shouldKeep = brogrammerFilter.shouldKeep(brogrammer);

        // then
        assertThat(shouldKeep, is(isValid));
    }

    private static Stream<Arguments> createBrogrammerNames() {
        return Stream.of(
                Arguments.of("SoumBill", true),
                Arguments.of("ChriNikos", true),
                Arguments.of("Someone123", false),
                Arguments.of("aiaosdkaopidoaisoaidoaidoapsidopasidopasido", false),
                Arguments.of("a", false)
        );
    }
}