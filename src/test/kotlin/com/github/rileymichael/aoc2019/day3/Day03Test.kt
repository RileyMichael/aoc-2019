package com.github.rileymichael.aoc2019.day3

import org.junit.jupiter.api.*
import org.junit.jupiter.params.*
import org.junit.jupiter.params.provider.*

class Day03Test {
    @ParameterizedTest
    @MethodSource("part1")
    fun part1(input: String, expected: Int) {
        val wires = parseInput(input.split('\n'))
        val actual = part1(wires)
        Assertions.assertEquals(expected, actual)
    }

    companion object {
        @JvmStatic
        fun part1() = listOf(
            Arguments.of("R75,D30,R83,U83,L12,D49,R71,U7,L72\nU62,R66,U55,R34,D71,R55,D58,R83",
                159),
            Arguments.of("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51\nU98,R91,D20,R16,D67,R40,U7,R15,U6,R7",
                135)
        )
    }
}
