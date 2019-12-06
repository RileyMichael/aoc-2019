package com.github.rileymichael.aoc2019.intcode

typealias Intcode = MutableList<Int>

fun List<Int>.toIntcode(): Intcode {
    return this.toMutableList()
}

class Computer(
    private var instructions: List<Int>
) {
    private var instructionPointer = 0
    private var inputPointer = 0
    private var modes = listOf<Mode>()
    var memory = instructions.toIntcode()
    var input = listOf<Int>()
    var output = mutableListOf<Int>()

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

    fun getParam(offset: Int): Int {
        return when (modes[offset - 1]) {
            Mode.Immediate -> get(instructionPointer + offset)
            Mode.Position -> get(get(instructionPointer + offset))
        }
    }

    fun getOutputAddress(offset: Int) = memory[offset + instructionPointer]

    fun getAndIncrementInput() = input[inputPointer++]

    fun reset() {
        memory = instructions.toIntcode()
        instructionPointer = 0
        inputPointer = 0
    }

    private fun getInstruction(): Instruction {
        memory[instructionPointer].let { value ->
            val opcode = value % 100
            val instruction = INSTRUCTIONS[opcode]
                ?: error("Error: Instruction ${memory[instructionPointer]} not found.")


            modes = value.toString()
                .dropLast(2)
                .reversed()
                .padEnd(instruction.size - 1, '0')
                .map { it.toString().toInt().toMode() }

            return instruction
        }
    }

    private fun Instruction.execute() {
        this.execute(this@Computer)
    }

    companion object {
        const val OUTPUT_ADDRESS = 0

        val INSTRUCTIONS = mapOf<Int, Instruction>(
            1 to AddInstruction,
            2 to MultiplyInstruction,
            3 to InputInstruction,
            4 to OutputInstruction,
            99 to HaltInstruction
        )
    }
}



