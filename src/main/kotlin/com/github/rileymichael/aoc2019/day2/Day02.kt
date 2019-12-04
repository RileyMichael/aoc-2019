package com.github.rileymichael.aoc2019.day2

import com.github.rileymichael.aoc2019.*

fun main() {
    val input = readInput("day02")
        .flatMap { it.split(',') }
        .map { it.toInt() }

    // Part 1
    val part1 = run(input.toMutableList(), 12, 2)
    println("Part 1: ${part1[0]}")

    // Part 2
    val part2 = findSolution(input.toMutableList(), 19690720)
    println("Part 2: ${100 * part2.first + part2.second}")
}

fun run(list: MutableList<Int>, noun: Int, verb: Int): MutableList<Int> {
    var p = 0
    list[1] = noun
    list[2] = verb

    while (list[p] != 99) {
        when (list[p]) {
            1 -> {
                list[list[p + 3]] = list[list[p + 1]] + list[list[p + 2]]
            }
            2 -> {
                list[list[p + 3]] = list[list[p + 1]] * list[list[p + 2]]
            }
        }
        p += 4
    }
    return list
}


fun findSolution(list: List<Int>, desired: Int): Pair<Int, Int> {
    for (noun in 0..99) {
        for (verb in 0..99) {
            if (run(list.toMutableList(), noun, verb)[0] == desired) {
                return Pair(noun, verb)
            }
        }
    }

    throw NoSuchElementException("Solution not found for desired value.")
}
