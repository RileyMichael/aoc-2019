package com.github.rileymichael.aoc2019.day4

import com.github.rileymichael.aoc2019.*

fun main() {
    val (start, end) = readInput("day04")[0].split('-').map { it.toInt() }
    val range = IntRange(start, end)

    // Part 1
    val part1 = part1(range)
    println("Part 1: $part1")
}



fun part1(range: IntRange): Int {
    val filtered = range.filter { it.validateLength() }
        .filter { it.validateAdjacent() }
        .filter { it.validateIncrease() }
        .distinct()

    return filtered.size
}

// validations
fun Int.validateLength(): Boolean {
    return this.toString().length == 6
}

fun Int.validateAdjacent(): Boolean {
    val chars = this.toString().toCharArray()
    var count = 0
    chars.forEachIndexed { index, c ->
        if (index != chars.size - 1 && c == chars[index + 1])
            count++
    }

    return count >= 1
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
