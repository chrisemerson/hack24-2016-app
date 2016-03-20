package uk.co.cemerson.hack24.bigcrane.BigCrane.Instructions;

import uk.co.cemerson.hack24.bigcrane.BigCrane.Command;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Commands.MoveRightCommand;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Game;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Instruction;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Program;
import uk.co.cemerson.hack24.bigcrane.R;

public class MoveRightInstruction extends Instruction
{
    public MoveRightInstruction(Program program) {
        super(program);
    }

    @Override
    public void execute(Game game) {
        Command command = new MoveRightCommand();

        command.executeCommand(game.getRobotArmInterface(), game.getProgram());
        game.moveRight();
    }

    @Override
    public int getIconResourceId() {
        return R.mipmap.instruction_right;
    }
}
