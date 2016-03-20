package uk.co.cemerson.hack24.bigcrane.BigCrane.Instructions;

import java.util.ArrayList;
import java.util.List;

import uk.co.cemerson.hack24.bigcrane.BigCrane.Command;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Commands.MoveRightCommand;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Instruction;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Program;

public class GrabOrReleaseCrateInstruction extends Instruction
{
    public GrabOrReleaseCrateInstruction(Program program) {
        super(program);
    }

    @Override
    public List<Command> getCommandList() {
        List<Command> commandList = new ArrayList<>();

        commandList.add(new MoveRightCommand());

        return commandList;
    }
}
