package com.github.rileymichael.aoc2019

object Utils {
    fun readInput(day: String): List<String> {
        val lines = this::class.java
            .classLoader
            .getResourceAsStream(day)
            ?.bufferedReader()
            ?.readLines()

        requireNotNull(lines, { "Input for day $day not found."})

        return lines
    }
}
