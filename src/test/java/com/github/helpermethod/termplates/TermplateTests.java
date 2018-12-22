package com.github.helpermethod.termplates;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.github.helpermethod.termplates.Termplates.render;
import static com.github.helpermethod.termplates.Termplates.renderFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TermplateTests {
    @Test
    void testRender() {
        Map<String, Object> model = new HashMap<>();
        model.put("name", "TERMplates");

        assertEquals("Hello TERMplates!", render("Hello {{name}}!", model));
    }

    @Test
    void testRenderFile() {
        Map<String, Object> model = new HashMap<>();
        model.put("name", "TERMplates");

        assertEquals("Hello TERMplates!", renderFile("hello", model));
    }
}