package com.github.rileymichael.aoc2019.intcode

abstract class Instruction(val size: Int) {
    abstract fun execute(computer: Computer)
}

object AddInstruction : Instruction(4) {
    override fun execute(computer: Computer) {
        val a = computer.dereferenceParam(1)
        val b = computer.dereferenceParam(2)
        val outputAddress = computer.getParam(3)

        computer.set(outputAddress, a + b)
    }
}

object MultiplyInstruction : Instruction(4) {
    override fun execute(computer: Computer) {
        val a = computer.dereferenceParam(1)
        val b = computer.dereferenceParam(2)
        val outputAddress = computer.getParam(3)

        computer.set(outputAddress, a * b)
    }
}

object HaltInstruction : Instruction(1) {
    override fun execute(computer: Computer) {
        error("You can't execute this..")
    }
}
