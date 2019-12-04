package com.github.rileymichael.aoc2019.day3

import com.github.rileymichael.aoc2019.*

fun main() {
    val input = readInput("day03")
    val wires = parseInput(input)

    // Part 1
    val closest = part1(wires)
    println("Part 1: $closest")

    // Part 2
    val min = part2(wires)
    println("Part 2: $min")
}

val origin = Point(0, 0)
typealias Wire = List<Pair<Direction, Int>>

fun part1(wires: List<Wire>): Int {
    val points = wires.map { trace(it) }

    return points[0].intersect(points[1]).map { it.distance(origin) }.min()!!
}

fun part2(wires: List<Wire>): Int {
    val points = wires.map { trace(it) }
    val intersections = points[0].intersect(points[1])

    val distances = points.map { list ->
        list.mapIndexed { index, point ->
            point to index + 1
        }.filter {
            intersections.contains(it.first)
        }.asSequence()
    }

    return (distances[0] + distances[1])
        .groupBy({ it.first }, { it.second })
        .map { it.value.sum() }
        .min()!!
}

fun parseInput(input: List<String>): List<Wire> {
    return input.map { wire ->
        wire.split(',').map {
            Pair(it[0].toDirection(), it.substring(1).toInt())
        }
    }
}

fun trace(wire: Wire): List<Point> {
    val points = emptyList<Point>().toMutableList()

    var position = origin.copy()

    wire.forEach { (direction, count) ->
        repeat(count) {
            position += direction
            points += position
        }
    }

    return points
}
