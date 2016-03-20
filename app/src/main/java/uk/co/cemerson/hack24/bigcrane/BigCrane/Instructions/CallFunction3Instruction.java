package uk.co.cemerson.hack24.bigcrane.BigCrane.Instructions;

import java.util.ArrayList;
import java.util.List;

import uk.co.cemerson.hack24.bigcrane.BigCrane.Command;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Commands.MoveRightCommand;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Game;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Instruction;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Program;
import uk.co.cemerson.hack24.bigcrane.R;

public class CallFunction3Instruction extends Instruction
{
    public CallFunction3Instruction(Program program) {
        super(program);
    }

    @Override
    public void execute(Game game) {
        game.addInstructionsFromFunction(game.getProgram().getFunction3());
    }

    @Override
    public int getIconResourceId() {
        return R.mipmap.instruction_3;
    }
}
