package com.github.rileymichael.aoc2019

fun readInput(day: String): List<String> {
    val lines = ClassLoader
        .getSystemResourceAsStream(day)
        ?.bufferedReader()
        ?.readLines()

    requireNotNull(lines, { "Input for day $day not found."})

    return lines
}
