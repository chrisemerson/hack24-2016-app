package uk.co.cemerson.hack24.bigcrane.BigCrane;

abstract public class Level {
    private BoardState start;
    private BoardState goal;

    public BoardState getStart() {
        return start;
    }

    protected void setStart(BoardState start) {
        this.start = start;
    }

    public BoardState getGoal() {
        return goal;
    }

    protected void setGoal(BoardState goal) {
        this.goal = goal;
    }
}
