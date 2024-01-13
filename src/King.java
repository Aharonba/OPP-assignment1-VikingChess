public class King extends ConcretePiece {

    private String type;

    private int id;

    King(Player owner, int id) {
        this.piece_owner = owner;

        if (piece_owner.isPlayerOne() == true) {
            type = "♚";
        } else {
            type = "♔";
        }

        this.id = id;
    }

    @Override
    public String getType() {
        return type;
    }


}
