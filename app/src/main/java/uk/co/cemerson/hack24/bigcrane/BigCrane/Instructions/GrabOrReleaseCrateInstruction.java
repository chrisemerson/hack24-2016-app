package uk.co.cemerson.hack24.bigcrane.BigCrane.Instructions;

import uk.co.cemerson.hack24.bigcrane.BigCrane.BoardState;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Command;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Commands.GrabCommand;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Commands.MoveDownCommand;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Commands.MoveUpCommand;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Commands.ReleaseCommand;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Game;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Instruction;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Program;
import uk.co.cemerson.hack24.bigcrane.R;

public class GrabOrReleaseCrateInstruction extends Instruction
{
    public GrabOrReleaseCrateInstruction(Program program) {
        super(program);
    }

    @Override
    public void execute(Game game) {
        Command command;
        BoardState currentBoardState = game.getCurrentBoardState();

        if (currentBoardState.getCrateInClaw() == null) {
            command = new MoveDownCommand(game.getCurrentStackSize());
            command.executeCommand(game.getRobotArmInterface(), game.getProgram());

            command = new GrabCommand();
            command.executeCommand(game.getRobotArmInterface(), game.getProgram());

            currentBoardState.setCrateInClaw(currentBoardState.getCurrentStack().popCrate());

            command = new MoveUpCommand();
            command.executeCommand(game.getRobotArmInterface(), game.getProgram());
        } else {
            command = new MoveDownCommand(game.getCurrentStackSize() + 1);
            command.executeCommand(game.getRobotArmInterface(), game.getProgram());

            command = new ReleaseCommand();
            command.executeCommand(game.getRobotArmInterface(), game.getProgram());

            currentBoardState.getCurrentStack().pushCrate(currentBoardState.getCrateInClaw());
            currentBoardState.setCrateInClaw(null);

            command = new MoveUpCommand();
            command.executeCommand(game.getRobotArmInterface(), game.getProgram());

        }
    }

    @Override
    public int getIconResourceId() {
        return R.mipmap.instruction_down;
    }
}
