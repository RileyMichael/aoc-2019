package com.github.rileymichael.aoc2019.intcode

typealias Intcode = MutableList<Int>

fun List<Int>.toIntcode(): Intcode {
    return this.toMutableList()
}

class Computer(var input: List<Int>) {
    private var instructionPointer = 0
    private var memory = input.toIntcode()

    fun compute() {
        while (true) {
            val instruction = getInstruction()

            if (instruction == HaltInstruction)
                break

            instruction.execute()
            instructionPointer += instruction.size
        }
    }

    fun set(address: Int, value: Int) = memory.set(address, value)

    fun get(address: Int) = memory[address]

    fun getParam(offset: Int) = get(instructionPointer + offset)

    fun dereferenceParam(offset: Int) = get(getParam(offset))

    fun reset() {
        memory = input.toIntcode()
        instructionPointer = 0
    }

    private fun getInstruction(): Instruction {
        return INSTRUCTIONS[memory[instructionPointer]]
            ?: error("Error: Instruction ${memory[instructionPointer]} not found.")
    }

    private fun Instruction.execute() {
        this.execute(this@Computer)
    }

    companion object {
        const val OUTPUT_ADDRESS = 0

        val INSTRUCTIONS = mapOf<Int, Instruction>(
            1 to AddInstruction,
            2 to MultiplyInstruction,
            99 to HaltInstruction
        )
    }
}


