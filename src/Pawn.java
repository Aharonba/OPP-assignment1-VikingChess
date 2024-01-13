public class Pawn extends ConcretePiece {

    private int eating_counter = 0;
    private String type;

    private int id;

    Pawn(Player owner, int id) {
        this.piece_owner = owner;
        if (piece_owner.isPlayerOne() == true) {
            type = "♟";
        } else {
            type = "♙";
        }

        this.id = id;
    }

    @Override
    public String getType() {
        return type;
    }


}