public abstract class ConcretePiece implements Piece {

    protected Player piece_owner;
    private Position piece_position;


    ConcretePiece() {
    }


    @Override
    public Player getOwner() {

        return piece_owner;
    }

    public String getType() {
        return null;
    }


}
