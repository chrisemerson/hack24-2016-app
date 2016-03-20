package uk.co.cemerson.hack24.bigcrane.BigCrane;

public class Crate {
    private int colour;

    private static int COLOUR_1 = 1;
    private static int COLOUR_2 = 1;
    private static int COLOUR_3 = 1;

    public Crate(int colour) {
        this.colour = colour;
    }

    public int getColour() {
        return colour;
    }
}
