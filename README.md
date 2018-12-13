# TERMplates

## Motivation

While libraries like picocli make parsing commandline arguments a breeze, there is still no elegant way to output rich, multiline text to the terminal due to Java's lack of multiline strings.

`TERMplates` tries to fill that gap: It uses [mustache.java](https://github.com/spullara/mustache.java) to ouput arbitrary text to the terminal and adds support for colorized text and text decorations.

## Features

* colorized text
* text decorations
* TTY detection

## Usage
