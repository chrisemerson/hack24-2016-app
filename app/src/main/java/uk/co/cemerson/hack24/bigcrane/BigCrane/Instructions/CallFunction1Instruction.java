package uk.co.cemerson.hack24.bigcrane.BigCrane.Instructions;

import uk.co.cemerson.hack24.bigcrane.BigCrane.Game;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Instruction;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Program;
import uk.co.cemerson.hack24.bigcrane.R;

public class CallFunction1Instruction extends Instruction
{
    public CallFunction1Instruction(Program program) {
        super(program);
    }

    @Override
    public void execute(Game game) {
        game.addInstructionsFromFunction(game.getProgram().getFunction1());
    }

    @Override
    public int getIconResourceId() {
        return R.mipmap.instruction_1;
    }
}
