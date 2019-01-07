package com.github.helpermethod.termplates;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.resolver.ClasspathResolver;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.Arrays.asList;

public class Termplates {
    public static Function<Object, String> compileInline(String template) {
        return renderFn(new DefaultMustacheFactory()
            .compile(new StringReader(template), ""));
    }

    public static Function<Object, String> compile(String name) {
        return renderFn(new DefaultMustacheFactory(new ClasspathResolver("templates"))
            .compile(name + ".mustache"));
    }

    public static String renderInline(String template, Object model) {
        return compileInline(template).apply(model);
    }

    public static String render(String name, Object model) {
        return compile(name).apply(model);
    }

    private static Function<Object, String> renderFn(Mustache mustache) {
        return model -> {
            StringWriter stringWriter = new StringWriter();
            Map<String, Object> ansiEscapes = new HashMap<>();
            ansiEscapes.put("term", new AnsiEscapes());

            mustache.execute(stringWriter, asList(ansiEscapes, model));

            return stringWriter.toString();
        };
    }
}