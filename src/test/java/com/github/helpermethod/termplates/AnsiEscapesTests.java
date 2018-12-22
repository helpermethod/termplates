package com.github.helpermethod.termplates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnsiEscapesTests {
    @Test
    void testBlack() {
        assertEquals("black", new AnsiEscapes().black().apply("black"));
    }
}