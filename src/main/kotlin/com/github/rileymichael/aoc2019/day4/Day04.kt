package com.github.rileymichael.aoc2019.day4

import com.github.rileymichael.aoc2019.*

fun main() {
    val (start, end) = Utils.readInput("day04")[0].split('-').map { it.toInt() }
    val range = IntRange(start, end)

    // Part 1
    val part1 = part1(range)
    println("Part 1: $part1")

    // Part 2
    val part2 = part2(range)
    println("Part 1: $part2")
}

fun part1(range: IntRange): Int {
    val filtered = range.filter { it.validateLength() }
        .filter { it.validateAdjacent(2, false) }
        .filter { it.validateIncrease() }
        .distinct()

    return filtered.size
}

fun part2(range: IntRange): Int {
    val filtered = range.filter { it.validateLength() }
        .filter { it.validateAdjacent(2, true) }
        .filter { it.validateIncrease() }
        .distinct()

    return filtered.size
}

// validations
fun Int.validateLength(): Boolean {
    return this.toString().length == 6
}

fun Int.validateAdjacent(amount: Int, exact: Boolean): Boolean {
    val chars = this.toString().toCharArray()
    var count = emptyMap<Char, Int>().toMutableMap().withDefault { 0 }

    chars.forEach { c ->
        count[c] = count.getValue(c).plus(1)
    }

    return count.filterValues { if (exact) it == amount else it >= amount }.isNotEmpty()
}

fun Int.validateIncrease(): Boolean {
    val digits = this.toString().map { it.toInt() }
    var current = digits.first()

    digits.forEach {
        if (it < current)
            return false

        current = it
    }

    return true
}
