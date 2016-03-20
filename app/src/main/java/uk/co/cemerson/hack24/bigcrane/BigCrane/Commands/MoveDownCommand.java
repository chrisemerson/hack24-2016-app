package uk.co.cemerson.hack24.bigcrane.BigCrane.Commands;

import uk.co.cemerson.hack24.bigcrane.BigCrane.Command;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Program;
import uk.co.cemerson.hack24.bigcrane.BigCrane.RobotArmInterface;

public class MoveDownCommand extends Command {
    private int stackSize;

    public MoveDownCommand(int stackSize) {
        this.stackSize = stackSize;
    }

    @Override
    public void executeCommand(RobotArmInterface robotArmInterface, Program program) {
        robotArmInterface.moveDown(stackSize);
    }
}
