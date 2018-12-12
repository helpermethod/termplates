package com.github.helpermethod.termplates;

import java.util.function.Function;

class AnsiEscapes {
    // colors
    Function<String, String> black() {
        return escape("30");
    }

    Function<String, String> red() {
        return escape("31");
    }

    Function<String, String> green() {
        return escape("32");
    }

    Function<String, String> yellow() {
        return escape("33");
    }

    Function<String, String> blue() {
        return escape("34");
    }

    Function<String, String> magenta() {
        return escape("35");
    }

    Function<String, String> cyan() {
        return escape("36");
    }

    Function<String, String> white() {
        return escape("37");
    }

    // decorations
    Function<String, String> bold() {
        return escape("1");
    }

    Function<String, String> underline() {
        return escape("4");
    }

    Function<String, String> reverse() {
        return escape("7");
    }

    private static Function<String, String> escape(String code) {
        return System.console() == null ? text -> text : text -> "\u001b[" + code + "m" + text + "\u001b[0m";
    }
}
