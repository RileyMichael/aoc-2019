package com.github.rileymichael.aoc2019.day4

import org.junit.jupiter.api.*
import org.junit.jupiter.params.*
import org.junit.jupiter.params.provider.*

class Day04Test {
    @ParameterizedTest
    @MethodSource("part1")
    fun part1(input: Int, expected: Boolean) {
        val actual = input.validateLength() && input.validateAdjacent(2, false) && input.validateIncrease()

        Assertions.assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("part2")
    fun part2(input: Int, expected: Boolean) {
        val actual = input.validateLength() && input.validateAdjacent(2, true) && input.validateIncrease()

        Assertions.assertEquals(expected, actual)
    }


    companion object {
        @JvmStatic
        fun part1() = listOf(
            Arguments.of(111111, true),
            Arguments.of(223450, false),
            Arguments.of(123789, false)
        )

        @JvmStatic
        fun part2() = listOf(
            Arguments.of(112233, true),
            Arguments.of(123444, false),
            Arguments.of(111122, true)
        )
    }
}
