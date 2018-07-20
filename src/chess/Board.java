package chess;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pawn> pawns = new ArrayList<>();

    public int getNumberOfPawns() {
        return pawns.size();
    }

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public Pawn get(int index) {
        return pawns.get(index);
    }
}
