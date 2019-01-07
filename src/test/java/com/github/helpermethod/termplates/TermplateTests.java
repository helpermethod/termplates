package com.github.helpermethod.termplates;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.github.helpermethod.termplates.Termplates.renderInline;
import static com.github.helpermethod.termplates.Termplates.render;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TermplateTests {
    @Test
    void testRenderInline() {
        Map<String, Object> model = new HashMap<>();
        model.put("name", "TERMplates");

        assertEquals("Hello TERMplates!", renderInline("Hello {{name}}!", model));
    }

    @Test
    void testRender() {
        Map<String, Object> model = new HashMap<>();
        model.put("name", "TERMplates");

        assertEquals("Hello TERMplates!", render("hello", model));
    }
}