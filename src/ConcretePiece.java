import java.util.ArrayList;

public abstract class ConcretePiece implements Piece {

    protected Player piece_owner;
    private Position piece_position;

    private int id;

    private Position first_position;

    private int edible_amount = 0;


    private ArrayList<Position> step_history = new ArrayList<Position>();


    private int squares_move = 0;


    ConcretePiece(int id) {

        this.id = id;
    }


    @Override
    public Player getOwner() {

        return piece_owner;
    }

    public String getType() {
        return null;
    }


    public Position getPiece_position() {
        return piece_position;
    }

    public void setPiece_position(Position piece_position) {
        this.piece_position = piece_position;
    }

    public ArrayList<Position> getStep_history() {
        return step_history;
    }

    public void setStep_history(Position new_step) {
        step_history.add(new_step);
    }


    public int getId() {
        return id;
    }

    public int getEdible_amount() {
        return edible_amount;
    }

    public void setEdible_amount() {
        this.edible_amount = edible_amount + 1;
    }

    public int getSquares_move() {
        return squares_move;
    }

    public void setSquares_move(int squares_move) {
        this.squares_move = squares_move;
    }
}
