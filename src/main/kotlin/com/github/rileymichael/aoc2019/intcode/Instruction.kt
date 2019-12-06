package com.github.rileymichael.aoc2019.intcode

abstract class Instruction(val size: Int) {
    abstract fun execute(computer: Computer)
}

object AddInstruction : Instruction(4) {
    override fun execute(computer: Computer) {
        computer.run {
            val a = getParam(1)
            val b = getParam(2)
            val outputAddress = getOutputAddress(3)

            set(outputAddress, a + b)
        }
    }
}

object MultiplyInstruction : Instruction(4) {
    override fun execute(computer: Computer) {
        computer.run {
            val a = getParam(1)
            val b = getParam(2)
            val outputAddress = getOutputAddress(3)

            set(outputAddress, a * b)
        }
    }
}

object InputInstruction : Instruction(2) {
    override fun execute(computer: Computer) {
        computer.run {
            val outputAddress = getOutputAddress(1)
            set(outputAddress, getAndIncrementInput())
        }
    }
}

object OutputInstruction : Instruction(2) {
    override fun execute(computer: Computer) {
        computer.run {
            output.add(getParam(1))
        }
    }
}



object HaltInstruction : Instruction(1) {
    override fun execute(computer: Computer) {
        error("You can't execute this..")
    }
}
