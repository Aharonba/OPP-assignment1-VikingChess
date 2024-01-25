public class Pawn extends ConcretePiece {

    private int eating_counter = 0;
    private String type;



    Pawn(Player owner, int id) {
        super(id);
        this.piece_owner = owner;
        if (owner.isPlayerOne() == true) {
            this.type = "♙";
        } else {
            this.type = "♟";
        }

    }

    @Override
    public String getType() {
        return this.type;
    }


}