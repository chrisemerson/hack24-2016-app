package uk.co.cemerson.hack24.bigcrane.BigCrane;

public class Program
{
    private Function function1;
    private Function function2;
    private Function function3;

    private boolean hasCrate = false;

    public Program(Function function1, Function function2, Function function3) {
        this.function1 = function1;
        this.function2 = function2;
        this.function3 = function3;
    }

    public Function getFunction1() {
        return function1;
    }

    public Function getFunction2() {
        return function2;
    }

    public Function getFunction3() {
        return function3;
    }

    public void setHasCrate(boolean hasCrate) {
        this.hasCrate = hasCrate;
    }

    public boolean hasCrate()
    {
        return hasCrate;
    }
}
