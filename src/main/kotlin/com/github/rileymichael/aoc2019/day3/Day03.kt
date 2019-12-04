package com.github.rileymichael.aoc2019.day3

import com.github.rileymichael.aoc2019.*

fun main() {
    val input = readInput("day03")
    val wires = parseInput(input)

    // Part 1
    val min = part1(wires)
    println("Part 1: $min")

    // Part 2
}

fun part1(wires: List<Wire>): Int {
    val center = Point(0,0)

    val points = wires.map { trace(it) }

    return points[0].intersect(points[1]).map { it.distance(center) }.min()!!
}

typealias Wire = List<Pair<Direction, Int>>

fun parseInput(input: List<String>): List<Wire> {
    return input.map { wire ->
        wire.split(',').map {
            Pair(it[0].toDirection(), it.substring(1).toInt())
        }
    }
}

fun trace(wire: Wire): List<Point> {
    val points = emptyList<Point>().toMutableList()

    var position = Point(0, 0)

    wire.forEach { (direction, count) ->
        repeat(count) {
            position += direction
            points += position
        }
    }

    return points
}
