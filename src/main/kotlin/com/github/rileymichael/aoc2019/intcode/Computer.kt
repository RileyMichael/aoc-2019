package com.github.rileymichael.aoc2019.intcode

class Computer(
    private var instructions: List<Int>
) {
    var instructionPointer = 0
    var inputPointer = 0
    var memory = instructions.toIntcode()
    var input = listOf<Int>()
    var output = mutableListOf<Int>()
    private var modes = listOf<Mode>()

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

    fun getParam(offset: Int): Int {
        return when (modes[offset - 1]) {
            Mode.Immediate -> memory[instructionPointer + offset]
            Mode.Position -> memory[memory[instructionPointer + offset]]
        }
    }

    fun reset() {
        memory = instructions.toIntcode()
        instructionPointer = 0
        inputPointer = 0
        output = emptyList<Int>().toMutableList()
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

        val INSTRUCTIONS = mapOf(
            1 to AddInstruction,
            2 to MultiplyInstruction,
            3 to InputInstruction,
            4 to OutputInstruction,
            5 to JumpIfTrueInstruction,
            6 to JumpIfFalseInstruction,
            7 to LessThanInstruction,
            8 to EqualsInstruction,
            99 to HaltInstruction
        )
    }
}

typealias Intcode = MutableList<Int>

fun List<Int>.toIntcode(): Intcode {
    return this.toMutableList()
}
