package uk.co.cemerson.hack24.bigcrane.BigCrane;

public interface RobotArmInterface
{
    public void moveLeft();

    public void moveRight();

    public void moveDown(int stackSize);

    public void moveUp();

    public void grab();

    public void release();

    public void win();

    public void lose();
}
