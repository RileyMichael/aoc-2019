package com.github.rileymichael.aoc2019.day3

import java.lang.IllegalArgumentException

enum class Direction {
    UP,
    RIGHT,
    DOWN,
    LEFT
}

fun Char.toDirection(): Direction {
    return when (this) {
        'U' -> Direction.UP
        'R' -> Direction.RIGHT
        'D' -> Direction.DOWN
        'L' -> Direction.LEFT
        else -> throw IllegalArgumentException("$this is not a Direction")
    }
}
