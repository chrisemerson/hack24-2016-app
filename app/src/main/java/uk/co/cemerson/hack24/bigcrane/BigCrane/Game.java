package uk.co.cemerson.hack24.bigcrane.BigCrane;

import android.util.Log;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import uk.co.cemerson.hack24.bigcrane.BigCrane.Commands.WinCommand;

public class Game {
    private Program program;
    private Level level;
    private RobotArmInterface robotArmInterface;

    private Queue<Instruction> instructions = new ArrayBlockingQueue<>(200);

    private BoardState currentBoardState;

    public Game(Program program, Level level, RobotArmInterface robotArmInterface)
    {
        this.program = program;
        this.level = level;
        currentBoardState = level.getStart();
        this.robotArmInterface = robotArmInterface;
    }

    public void playGame()
    {
        addInstructionsFromFunction(program.getFunction1());

        while (!instructions.isEmpty()) {
            Instruction currentInstruction = instructions.poll();
            currentInstruction.execute(this);

            Log.i("BigCrane", "Boardstate: " + currentBoardState.getStateString());

            if (currentBoardState.getStateString().equals(level.getGoal().getStateString())) {
                Command winCommand = new WinCommand();
                winCommand.executeCommand(getRobotArmInterface(), getProgram());

                instructions = new ArrayBlockingQueue<>(200);
            }
        }
    }

    public void stopGame()
    {
    }

    public Program getProgram()
    {
        return program;
    }

    public RobotArmInterface getRobotArmInterface()
    {
        return robotArmInterface;
    }

    public int getCurrentStackSize()
    {
        return getCurrentStack().size();
    }

    public Stack getCurrentStack()
    {
        return currentBoardState.getCurrentStack();
    }

    public void moveRight()
    {
        currentBoardState.moveRight();
    }

    public void moveLeft()
    {
        currentBoardState.moveLeft();
    }

    public void addInstructionsFromFunction(Function function)
    {
        List<Instruction> instructionList = function.getInstructions();

        Queue<Instruction> newQueue = new ArrayBlockingQueue<>(200);

        for (Instruction instruction : instructionList) {
            newQueue.add(instruction);
        }

        for (Instruction instruction : instructions) {
            newQueue.add(instruction);
        }

        instructions = newQueue;
    }

    public BoardState getCurrentBoardState()
    {
        return currentBoardState;
    }
}
