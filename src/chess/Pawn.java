package chess;

/**
 * 国际象棋中的卒
 */
public class Pawn {
    public static final String WHITE = "white";
    public static final String BLACK = "black";
    private String color;

    public Pawn(String color) {
        this.color = color;
    }

    public Pawn() {
        color = WHITE;
    }

    public String getColor() {
        return color;
    }
}
