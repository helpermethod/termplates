# TERMplates

## Motivation

While libraries like [picocli](https://picocli.info/) make parsing commandline arguments a breeze, there's no elegant way to output rich, multiline text to the terminal due to Java's lack of multiline strings.

`TERMplates` tries to fill that gap: It uses [mustache.java](https://github.com/spullara/mustache.java) to output arbitrary text to the terminal and adds support for colors and text decorations.

## Features

* colorized text
* text decorations
* TTY detection

## Setup

### Maven

### Gradle

## Getting Started

Create a file named `hello.mustache` and place it under `src/main/resources/templates`.

```mustache
Hello {{name}}!
```

Next, create a file named `HelloTermplates.java`.

```java
public class HelloTermplates {
    public static void main(String[] args) {
        Map<String, String> model = new HashMap<String, String>();
        model.put("name", "TERMplates");
        
        Termplate.compile("hello").render(model, new PrintWriter(System.out));
    }
}
```

Run `HelloTermplates`. You should see the following output.

````bash
Hello TERMplates!
````

## API

## Usage

Hello {{name}}!

Hello {{#term.red}}{{name}}{{/term.red}}!

Hello {{#term.bold}}{{name}}{{/term.bold}}!

Hello {{#term.bold}}{{#term.red}}{{name}}{{/term.red}}{{/term.bold}}!
