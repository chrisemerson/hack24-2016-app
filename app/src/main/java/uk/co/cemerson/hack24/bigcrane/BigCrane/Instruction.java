package uk.co.cemerson.hack24.bigcrane.BigCrane;

abstract public class Instruction
{
    protected Program program;

    public Instruction(Program program)
    {
        this.program = program;
    }

    public abstract void getCommandList();
}
