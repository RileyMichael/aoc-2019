package com.github.rileymichael.aoc2019.intcode

abstract class Instruction(val size: Int) {
    abstract fun execute(computer: Computer)
}

object AddInstruction : Instruction(4) {
    override fun execute(computer: Computer) {
        computer.run {
            val a = getParam(1)
            val b = getParam(2)
            val outputAddress = memory[instructionPointer + 3]

            set(outputAddress, a + b)
        }
    }
}

object MultiplyInstruction : Instruction(4) {
    override fun execute(computer: Computer) {
        computer.run {
            val a = getParam(1)
            val b = getParam(2)
            val outputAddress = memory[instructionPointer + 3]

            set(outputAddress, a * b)
        }
    }
}

object InputInstruction : Instruction(2) {
    override fun execute(computer: Computer) {
        computer.run {
            val outputAddress = memory[instructionPointer + 1]
            set(outputAddress, input[inputPointer++])
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

object JumpIfTrueInstruction : Instruction(3) {
    override fun execute(computer: Computer) {
        computer.run {
            val a = getParam(1)
            val b = getParam(2)

            if (a != 0)
                instructionPointer = b - size
        }
    }
}

object JumpIfFalseInstruction : Instruction(3) {
    override fun execute(computer: Computer) {
        computer.run {
            val a = getParam(1)
            val b = getParam(2)

            if (a == 0)
                instructionPointer = b - size
        }
    }
}

object LessThanInstruction : Instruction(4) {
    override fun execute(computer: Computer) {
        computer.run {
            val a = getParam(1)
            val b = getParam(2)
            val outputAddress = memory[instructionPointer + 3]

            set(outputAddress, if (a < b) 1 else 0)
        }
    }
}

object EqualsInstruction : Instruction(4) {
    override fun execute(computer: Computer) {
        computer.run {
            val a = getParam(1)
            val b = getParam(2)
            val outputAddress = memory[instructionPointer + 3]

            set(outputAddress, if (a == b) 1 else 0)
        }
    }
}

object HaltInstruction : Instruction(1) {
    override fun execute(computer: Computer) {
        error("You can't execute this..")
    }
}
