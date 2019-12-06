package com.github.rileymichael.aoc2019.day5

import com.github.rileymichael.aoc2019.intcode.*
import org.junit.jupiter.api.*
import org.junit.jupiter.params.*
import org.junit.jupiter.params.provider.*

class Day05Test {
    fun part1() {
        // no example..
    }

    @ParameterizedTest
    @MethodSource("part2")
    fun part2(args: Int, expected: Int) {
        val inputs = "3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99"
        val instructions = inputs.split(',').map { it.toInt() }

        Computer(instructions).run {
            input = listOf(args)
            compute()
            Assertions.assertEquals(expected, output.last())
        }
    }

    companion object {
        @JvmStatic
        fun part2() = listOf(
            Arguments.of(7, 999),
            Arguments.of(8, 1000),
            Arguments.of(9, 1001)
        )
    }
}
