package uk.co.cemerson.hack24.bigcrane.BigCrane;

public class Board {
    private Stack stack1;
    private Stack stack2;
    private Stack stack3;
    private Stack stack4;
    private Stack stack5;

    public Board (Stack stack1, Stack stack2, Stack stack3, Stack stack4, Stack stack5)
    {
        this.stack1 = stack1;
        this.stack2 = stack2;
        this.stack3 = stack3;
        this.stack4 = stack4;
        this.stack5 = stack5;
    }

    public Stack getStack1() {
        return stack1;
    }

    public Stack getStack2() {
        return stack2;
    }

    public Stack getStack3() {
        return stack3;
    }

    public Stack getStack4() {
        return stack4;
    }

    public Stack getStack5() {
        return stack5;
    }
}
