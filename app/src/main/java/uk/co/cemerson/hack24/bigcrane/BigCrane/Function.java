package uk.co.cemerson.hack24.bigcrane.BigCrane;

import java.util.ArrayList;
import java.util.List;

public class Function
{
    private int instructionLimit;

    private List<Instruction> instructions = new ArrayList<>();

    public Function(int instructionLimit) {
        this.instructionLimit = instructionLimit;
    }

    public void addInstruction(Instruction instruction)
    {
        if (instructions.size() < instructionLimit) {
            instructions.add(instruction);
        }
    }

    public List<Instruction> getInstructions()
    {
        return instructions;
    }

    public void removeLastInstruction() {
        if (instructions.size() != 0) {
            instructions.remove(instructions.size() - 1);
        }
    }
}
