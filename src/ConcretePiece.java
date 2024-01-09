public abstract class ConcretePiece implements Piece {

    private ConcretePlayer piece_owner;
    private Position piece_position;


public ConcretePiece(){
}


    @Override
    public Player getOwner() {
        return piece_owner;
    }

    public String getType(){
        return null;
    }



}
