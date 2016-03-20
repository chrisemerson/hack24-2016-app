package uk.co.cemerson.hack24.bigcrane.BigCrane;

public abstract class Command {
    public abstract void executeCommand(RobotArmInterface robotArmInterface, Program program);
}
