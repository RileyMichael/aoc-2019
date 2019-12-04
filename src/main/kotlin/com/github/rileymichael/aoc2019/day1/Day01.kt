package com.github.rileymichael.aoc2019.day1

import com.github.rileymichael.aoc2019.*

fun main() {
    val modules = Utils.readInput("day01").map { it.toInt() }

    // Part 1
    val part1 = modules.map { fuelRequired(it) }.sum()
    println("Part 1: $part1")

    // Part 2
    val part2 = modules.map { recursiveFuel(it) }.sum()
    println("Part 2: $part2")
}

fun fuelRequired(mass: Int): Int {
    return mass / 3 - 2
}

fun recursiveFuel(mass: Int): Int {
    val fuel = fuelRequired(mass)

    return if (fuel < 0) {
        0
    } else {
        fuel + recursiveFuel(fuel)
    }
}


