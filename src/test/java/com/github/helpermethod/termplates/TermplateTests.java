package com.github.helpermethod.termplates;

import org.junit.jupiter.api.Test;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TermplateTests {
    @Test
    void testRenderTemplate() {
        Map<String, String> model = new HashMap<>();
        model.put("name", "Termplates");

        Writer writer = new StringWriter();

        Termplate.compile("hello").render(model, writer);

        assertEquals("Hello Termplates!", writer.toString());
    }
}