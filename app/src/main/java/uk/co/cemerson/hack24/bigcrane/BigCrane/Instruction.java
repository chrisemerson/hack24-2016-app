package uk.co.cemerson.hack24.bigcrane.BigCrane;

import java.util.List;

abstract public class Instruction
{
    protected Program program;

    public Instruction(Program program)
    {
        this.program = program;
    }

    public abstract List<Command> getCommandList();

    public abstract int getIconResourceId();
}
