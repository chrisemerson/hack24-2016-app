package uk.co.cemerson.hack24.bigcrane.BigCrane.Commands;

import uk.co.cemerson.hack24.bigcrane.BigCrane.Command;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Program;
import uk.co.cemerson.hack24.bigcrane.BigCrane.RobotArmInterface;

public class WinCommand extends Command {
    @Override
    public void executeCommand(RobotArmInterface robotArmInterface, Program program) {
        robotArmInterface.win();
    }
}
