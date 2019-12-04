package com.github.rileymichael.aoc2019.day1

import com.github.rileymichael.aoc2019.day1.*
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

    @ParameterizedTest
    @CsvSource(
        "14, 2",
        "1969, 966",
        "100756, 50346"
    )
    fun part2(input: Int, expected: Int) {
        val actual = recursiveFuel(input)

        assertEquals(expected, actual)
    }}
