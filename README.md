# TERMplates

`TERMplates` is a small wrapper around [mustache.java](https://github.com/spullara/mustache.java) which adds
ANSI escape codes to output colors and text decorations.

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

The static `render` method takes a Mustache template as a `String` and a model as a `Map` or `Object` as parameters
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

Colors and text decorations can be accessed by using the {{term}} namespace.

```java
System.out.println(Termplates.render("Hello {{term.red}}{{name}}{{/term.red}}", Map.of("name", "TERMplates")));
```

For a full list of supported escape sequences, see [ANSI Escape Codes](#ansi-escape-codes).

## ANSI Escape Codes