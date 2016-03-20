package uk.co.cemerson.hack24.bigcrane.BigCrane.Instructions;

import java.util.ArrayList;
import java.util.List;

import uk.co.cemerson.hack24.bigcrane.BigCrane.Command;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Instruction;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Program;
import uk.co.cemerson.hack24.bigcrane.R;

public class CallFunction1Instruction extends Instruction
{
    public CallFunction1Instruction(Program program) {
        super(program);
    }

    @Override
    public List<Command> getCommandList() {
        List<Command> commandList = new ArrayList<>();

        return commandList;
    }

    @Override
    public int getIconResourceId() {
        return R.mipmap.instruction_1;
    }
}
