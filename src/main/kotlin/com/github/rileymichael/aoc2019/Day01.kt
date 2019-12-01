package com.github.rileymichael.aoc2019


fun main() {
    val modules = readInput("day01").map { it.toInt() }

    val part1 = modules.map { fuelRequired(it) }.sum()

    println("Part 1: $part1")
}

fun fuelRequired(mass: Int): Int {
    return mass / 3 - 2
}


