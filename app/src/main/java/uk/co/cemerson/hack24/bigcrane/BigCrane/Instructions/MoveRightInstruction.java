package uk.co.cemerson.hack24.bigcrane.BigCrane.Instructions;

import java.util.ArrayList;
import java.util.List;

import uk.co.cemerson.hack24.bigcrane.BigCrane.Command;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Commands.MoveRightCommand;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Instruction;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Program;
import uk.co.cemerson.hack24.bigcrane.R;

public class MoveRightInstruction extends Instruction
{
    public MoveRightInstruction(Program program) {
        super(program);
    }

    @Override
    public List<Command> getCommandList() {
        List<Command> commandList = new ArrayList<>();

        commandList.add(new MoveRightCommand());

        return commandList;
    }

    @Override
    public int getIconResourceId() {
        return R.mipmap.instruction_right;
    }
}
