package uk.co.cemerson.hack24.bigcrane.BigCrane;

public interface RobotArmInterface
{
    public void moveLeft();

    public void moveRight();

    public void moveDown(int units);

    public void moveUp(int units);

    public void grab();

    public void release();
}
