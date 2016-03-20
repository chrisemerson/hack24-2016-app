package uk.co.cemerson.hack24.bigcrane.BigCrane.Levels;

import uk.co.cemerson.hack24.bigcrane.BigCrane.BoardState;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Crate;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Level;
import uk.co.cemerson.hack24.bigcrane.BigCrane.Stack;

public class Level1 extends Level {
    public Level1() {
        Stack startStack1 = new Stack();
        Stack startStack2 = new Stack();
        Stack startStack3 = new Stack();
        Stack startStack4 = new Stack();
        Stack startStack5 = new Stack();

        BoardState start = new BoardState(
                startStack1,
                startStack2,
                startStack3,
                startStack4,
                startStack5
        );

        startStack2.pushCrate(new Crate(1));
        startStack2.pushCrate(new Crate(2));
        startStack2.pushCrate(new Crate(3));

        Stack goalStack1 = new Stack();
        Stack goalStack2 = new Stack();
        Stack goalStack3 = new Stack();
        Stack goalStack4 = new Stack();
        Stack goalStack5 = new Stack();

        BoardState goal = new BoardState(
                goalStack1,
                goalStack2,
                goalStack3,
                goalStack4,
                goalStack5
        );

        goalStack5.pushCrate(new Crate(3));
        goalStack5.pushCrate(new Crate(2));
        goalStack5.pushCrate(new Crate(1));

        setStart(start);
        setGoal(goal);
    }
}
