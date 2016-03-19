package uk.co.cemerson.hack24.bigcrane.BigCrane.RobotArmInterfaces;

import uk.co.cemerson.hack24.bigcrane.BigCrane.RobotArmInterface;

public class NoOpRobotArmInterface implements RobotArmInterface {
    @Override
    public void moveLeft() {
    }

    @Override
    public void moveRight() {
    }

    @Override
    public void moveDown(int units) {
    }

    @Override
    public void moveUp(int units) {
    }

    @Override
    public void grab() {
    }

    @Override
    public void release() {
    }
}
