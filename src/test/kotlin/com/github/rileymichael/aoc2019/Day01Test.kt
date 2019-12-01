package com.github.rileymichael.aoc2019

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.*
import org.junit.jupiter.params.provider.*

class Day01Test {
    @ParameterizedTest
    @CsvSource(
        "12, 2",
        "14, 2",
        "1969, 654",
        "100756, 33583"
    )
    fun part1(input: Int, expected: Int) {
        val actual = fuelRequired(input)

        assertEquals(expected, actual)
    }
}
