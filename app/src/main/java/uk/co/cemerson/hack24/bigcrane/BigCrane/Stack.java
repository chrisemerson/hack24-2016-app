package uk.co.cemerson.hack24.bigcrane.BigCrane;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stack {
    Deque<Crate> crateStack = new ArrayDeque<Crate>();

    public void pushCrate(Crate crate)
    {
        crateStack.push(crate);
    }

    public Crate popCrate()
    {
        return crateStack.pop();
    }
}
