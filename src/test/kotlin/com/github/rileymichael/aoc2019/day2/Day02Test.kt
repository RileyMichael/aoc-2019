package com.github.rileymichael.aoc2019.day2

import org.junit.jupiter.api.*
import org.junit.jupiter.params.*
import org.junit.jupiter.params.provider.*

class Day02Test {
    @ParameterizedTest
    @MethodSource("part1")
    fun part1(input: String, expected: String) {
        val inputList = input.split(',').map { it.toInt() }
        val expectedList = expected.split(',').map { it.toInt() }

        val actual = run(
            inputList.toMutableList(),
            inputList[1],
            inputList[2]
        )

        Assertions.assertEquals(expectedList, actual)
    }

    @Test
    fun part2() {
        // no example..
    }


    companion object {
        @JvmStatic
        fun part1() = listOf(
            Arguments.of("1,0,0,0,99", "2,0,0,0,99"),
            Arguments.of("2,3,0,3,99", "2,3,0,6,99"),
            Arguments.of("2,4,4,5,99,0", "2,4,4,5,99,9801"),
            Arguments.of("1,1,1,4,99,5,6,0,99", "30,1,1,4,2,5,6,0,99")
        )
    }
}
