package com.github.rileymichael.aoc2019.day2

import com.github.rileymichael.aoc2019.*
import com.github.rileymichael.aoc2019.intcode.*
import com.github.rileymichael.aoc2019.intcode.Computer.Companion.OUTPUT_ADDRESS
import java.lang.IllegalArgumentException

fun main() {
    val input = Utils.readInput("day02")
        .flatMap { it.split(',') }
        .map { it.toInt() }


    Computer(input).run {
        // Part 1
        set(1, 12)
        set(2, 2)
        compute()
        println("Part 1: " + memory[OUTPUT_ADDRESS])

        reset()

        // Part 2
        println("Part 2: " + findSolution(19690720))
    }
}

fun Computer.findSolution(desired: Int): Int {
    for (noun in 0..99) {
        for (verb in 0..99) {
            set(1, noun)
            set(2, verb)
            compute()

            if (memory[OUTPUT_ADDRESS] == desired) {
                return 100 * noun + verb
            }

            reset()
        }
    }

    throw IllegalArgumentException("Solution not found for $desired")
}
