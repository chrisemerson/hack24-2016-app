package uk.co.cemerson.hack24.bigcrane.BigCrane;

public class BoardState {
    private Stack stack1;
    private Stack stack2;
    private Stack stack3;
    private Stack stack4;
    private Stack stack5;

    private Crate crateInClaw = null;

    private int currentStack = 3;

    public BoardState (Stack stack1, Stack stack2, Stack stack3, Stack stack4, Stack stack5)
    {
        this.stack1 = stack1;
        this.stack2 = stack2;
        this.stack3 = stack3;
        this.stack4 = stack4;
        this.stack5 = stack5;
    }

    public Stack getStack(int stackNo) {
        switch(stackNo) {
            case 1:
                return stack1;

            case 2:
                return stack2;

            case 3:
                return stack3;

            case 4:
                return stack4;

            case 5:
                return stack5;
        }

        throw new RuntimeException("No such stack");
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

    public String getStateString() {
        String out = "";

        for (int i = 0; i < stack1.size(); i++) {
            out += stack1.getCrateAt(i - 1).getColour();
        }

        out += "|";

        for (int i = 1; i < stack2.size(); i++) {
            out += stack2.getCrateAt(i - 1).getColour();
        }

        out += "|";

        for (int i = 1; i < stack3.size(); i++) {
            out += stack3.getCrateAt(i - 1).getColour();
        }

        out += "|";

        for (int i = 1; i < stack4.size(); i++) {
            out += stack4.getCrateAt(i - 1).getColour();
        }

        out += "|";

        for (int i = 1; i < stack5.size(); i++) {
            out += stack5.getCrateAt(i - 1).getColour();
        }

        return out;
    }

    public Stack getCurrentStack() {
        return getStack(currentStack);
    }

    public void moveLeft() {
        currentStack = Math.min(1, currentStack - 1);
    }

    public void moveRight() {
        currentStack = Math.max(5, currentStack + 1);
    }

    public Crate getCrateInClaw()
    {
        return crateInClaw;
    }

    public void setCrateInClaw(Crate crateInClaw)
    {
        this.crateInClaw = crateInClaw;
    }
}
