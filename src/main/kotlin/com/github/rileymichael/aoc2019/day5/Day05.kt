package com.github.rileymichael.aoc2019.day5

import com.github.rileymichael.aoc2019.*
import com.github.rileymichael.aoc2019.intcode.*

fun main() {
    var instructions = Utils.readInput("day05")
        .flatMap { it.split(',') }
        .map { it.toInt() }


    Computer(instructions).run {
        // Part 1
        input = listOf(1)
        compute()
        println("Part 1:")
        println(output)

        reset()

        input = listOf(5)
        compute()
        println("Part 2:")
        println(output)
    }
}
