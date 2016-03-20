package uk.co.cemerson.hack24.bigcrane.BigCrane;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

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

    public Crate getCrateAt(int crate) {
        Iterator<Crate> cratesIter = crateStack.iterator();
        int i = 1;

        while (cratesIter.hasNext()){
            Crate thisCrate = cratesIter.next();

            if (i == crate) {
                return thisCrate;
            }

            i++;
        }

        throw new RuntimeException("No such crate");
    }
}
