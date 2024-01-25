public class King extends ConcretePiece {

    private String  type ="♔";


    King(Player owner,int id) {
       super(id);
        this.piece_owner = owner;

    }

    @Override
    public String getType() {
        return type;
    }


}
