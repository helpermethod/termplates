# TERMplates

[![Download](https://api.bintray.com/packages/helpermethod/maven/termplates/images/download.svg)](https://bintray.com/helpermethod/maven/termplates/_latestVersion)

`TERMplates` is a small wrapper around [mustache.java](https://github.com/spullara/mustache.java) which adds support for
ANSI escape codes to render colors and text decorations.

## Features

* **Colors** Apply foreground and background colors.
* **Text Decorations** Underline and bolden text.
* **TTY detection** Ignore ANSI escape codes when not started from an interactive commandline.

## Installation

### Maven

```xml
<repositories>
    <repository>
        <id>bintray</id>
        <url>http://dl.bintray.com/helpermethod/maven</url>
    </repository>
</repositories>

<dependency>
  <groupId>com.github.helpermethod</groupId>
  <artifactId>termplates</artifactId>
  <version>0.1.0</version>
</dependency>
```

### Gradle

```groovy
repositories {
    maven {
        url  "https://dl.bintray.com/helpermethod/maven"
    }
}

compile 'com.github.helpermethod:termplates:0.1.0'
```

## Usage

The static `render` method takes a Mustache template of type `String` and a model of type `Map` or `Object`
and returns the rendered template as a `String`.

```java
Map<String, Object> model = new HashMap<>();
model.name = "TERMplates";

System.out.println(Termplates.render("Hello {{name}}!", model));
```

When using Java 10 or above, the above code can be shortened by using `Map.of`.

```java
System.out.println(Termplates.render("Hello {{name}}!", Map.of("name", "TERMplates")));
```

Colors can be accessed by using the {{term}} namespace.

```java
System.out.println(Termplates.render("Hello {{#term.red}}{{name}}{{/term.red}}", Map.of("name", "TERMplates")));
```

Colors and text decorations can be combined by nesting them (for a full list of supported escape sequences, see [ANSI Escape Codes](#ansi-escape-codes).
).

```java
System.out.println(Termplates.render("Hello {{#term.bold}}{{#term.red}}{{name}}{{/term.red}}{{term.bold}}", Map.of("name", "TERMplates")));
```

For rendering more complex templates, create a file ending on `.mustache` under `src/main/resources/templates`, e.g.
`movies.mustache`.

```hbs
{{#term.underline}}MOVIES{{/term.underline}}

{{! iterates over the `movies` array and renders each element on its own line }}
{{#movies}}
{{.}}
{{/movies}}
```

Use the static `renderFile` method to render the file containing the template.

```java
// note that you reference the file only by its prefix, i.e. "movies", not "movies.mustache"
System.out.println(Termplates.renderFile("movies", Map.of("movies", List.of("Evil Dead", "Evil Dead 2", "Army Of Darkness"))));
```

## ANSI Escape Codes

## Foreground Colors

| Color | Function |
| --- | --- |
| black | `term.black` |
| red | `term.red` |
| green | `term.green` |
| yellow | `term.yellow` |
| blue | `term.magenta` |
| magenta | `term.magenta` |
| cyan | `term.cyan` |
| white | `term.white` |

## Text Decorations

| Decoration | Function |
| --- | --- |
| bold | `term.bold` |
| underline | `term.underline` |
| reverse | `term.reverse` |
