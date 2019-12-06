package com.github.rileymichael.aoc2019.intcode

enum class Mode {
    Position,
    Immediate
}

fun Int.toMode(): Mode {
    return when (this) {
        0 -> Mode.Position
        1 -> Mode.Immediate
        else -> error("Invalid mode")
    }
}
