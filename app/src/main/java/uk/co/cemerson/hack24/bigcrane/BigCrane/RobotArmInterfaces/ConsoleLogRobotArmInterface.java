package uk.co.cemerson.hack24.bigcrane.BigCrane.RobotArmInterfaces;

import android.util.Log;

import uk.co.cemerson.hack24.bigcrane.BigCrane.RobotArmInterface;

public class ConsoleLogRobotArmInterface implements RobotArmInterface {
    @Override
    public void moveLeft() {
        Log.i("BigCrane", "move left");
    }

    @Override
    public void moveRight() {
        Log.i("BigCrane", "move right");
    }

    @Override
    public void moveDown(int stackSize) {
        Log.i("BigCrane", "move down " + stackSize);
    }

    @Override
    public void moveUp() {
        Log.i("BigCrane", "move up");
    }

    @Override
    public void grab() {
        Log.i("BigCrane", "grab");
    }

    @Override
    public void release() {
        Log.i("BigCrane", "release");
    }

    @Override
    public void win() {
        Log.i("BigCrane", "win");
    }

    @Override
    public void lose() {
        Log.i("BigCrane", "lose");
    }
}
