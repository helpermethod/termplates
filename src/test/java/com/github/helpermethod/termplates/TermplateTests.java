package com.github.helpermethod.termplates;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.github.helpermethod.termplates.Termplates.render;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TermplateTests {
    @Test
    void testRender() {
        Map<String, String> model = new HashMap<>();
        model.put("name", "Termplates");

        assertEquals("Hello Termplates!", render("Hello {{name}}!", model));
    }
}