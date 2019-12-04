package com.github.rileymichael.aoc2019.day3

import kotlin.math.*

data class Point(val x: Int, val y: Int) {
    operator fun plus(direction: Direction) = when (direction) {
        Direction.UP -> Point(x, y + 1)
        Direction.RIGHT -> Point(x + 1, y)
        Direction.DOWN -> Point(x, y - 1)
        Direction.LEFT -> Point(x - 1, y)
    }

    fun distance(point: Point) = abs(x - point.x) + abs(y - point.y)
}
