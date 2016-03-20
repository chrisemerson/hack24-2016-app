package uk.co.cemerson.hack24.bigcrane.BigCrane.Instructions;

import java.util.ArrayList;
import java.util.List;

import uk.co.cemerson.hack24.bigcrane.BigCrane.Command;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Commands.MoveLeftCommand;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Commands.MoveRightCommand;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Game;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Instruction;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Program;
import uk.co.cemerson.hack24.bigcrane.R;

public class MoveLeftInstruction extends Instruction
{
    public MoveLeftInstruction(Program program) {
        super(program);
    }

    @Override
    public void execute(Game game) {
        Command command = new MoveLeftCommand();

        command.executeCommand(game.getRobotArmInterface(), game.getProgram());
        game.moveLeft();
    }

    @Override
    public int getIconResourceId() {
        return R.mipmap.instruction_left;
    }
}
