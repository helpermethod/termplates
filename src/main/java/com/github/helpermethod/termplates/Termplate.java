package com.github.helpermethod.termplates;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.resolver.ClasspathResolver;

import java.io.IOException;
import java.io.Writer;

import static java.util.Arrays.asList;

public class Termplate {
    private final Mustache mustache;

    private Termplate(Mustache mustache) {
        this.mustache = mustache;
    }

    public static Termplate compile(String name) {
        return new Termplate(new DefaultMustacheFactory(new ClasspathResolver("templates")).compile("name" + ".mustache"));
    }

    public void render(Object model, Writer writer) {
        try {
            mustache.execute(writer, asList(new AnsiEscapes(), model)).flush();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}