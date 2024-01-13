public class GameLogic implements PlayableLogic {

    private Piece[][] board;
    private Player player_1 = new ConcretePlayer(true);
    private Player player_2 = new ConcretePlayer(false);
    private boolean turn;


    GameLogic() {
        turn = true;
        board = new Piece[11][11];
        board_initialization(board);
    }

// I add this class


    public void board_initialization(Piece[][] board) {

        // player 1:

        board[0][3] = new Pawn(player_1, 1);
        board[0][4] = new Pawn(player_1, 2);
        board[0][5] = new Pawn(player_1, 3);
        board[0][6] = new Pawn(player_1, 4);
        board[0][7] = new Pawn(player_1, 5);
        board[1][5] = new Pawn(player_1, 6);

        board[10][3] = new Pawn(player_1, 20);
        board[10][4] = new Pawn(player_1, 21);
        board[10][5] = new Pawn(player_1, 22);
        board[10][6] = new Pawn(player_1, 23);
        board[10][7] = new Pawn(player_1, 24);
        board[9][5] = new Pawn(player_1, 19);

        board[3][0] = new Pawn(player_1, 7);
        board[4][0] = new Pawn(player_1, 9);
        board[5][0] = new Pawn(player_1, 11);
        board[6][0] = new Pawn(player_1, 15);
        board[7][0] = new Pawn(player_1, 17);
        board[5][1] = new Pawn(player_1, 12);


        board[3][10] = new Pawn(player_1, 8);
        board[4][10] = new Pawn(player_1, 10);
        board[5][10] = new Pawn(player_1, 14);
        board[6][10] = new Pawn(player_1, 16);
        board[7][10] = new Pawn(player_1, 18);
        board[5][9] = new Pawn(player_1, 13);


        //player 2:

        board[3][5] = new Pawn(player_2, 1);
        board[4][4] = new Pawn(player_2, 2);
        board[4][5] = new Pawn(player_2, 3);
        board[4][6] = new Pawn(player_2, 4);
        board[5][3] = new Pawn(player_2, 5);
        board[5][4] = new Pawn(player_2, 6);
        board[5][5] = new King(player_2, 7);
        board[5][6] = new Pawn(player_2, 8);
        board[5][7] = new Pawn(player_2, 19);
        board[6][4] = new Pawn(player_2, 10);
        board[6][5] = new Pawn(player_2, 11);
        board[6][6] = new Pawn(player_2, 12);
        board[7][5] = new Pawn(player_2, 13);







    }

    @Override
    public boolean move(Position a, Position b) {
        return false;
    }

    @Override
    public Piece getPieceAtPosition(Position position) {

        return board[position.x][position.y];
    }

    @Override
    public Player getFirstPlayer() {
        return null;
    }

    @Override
    public Player getSecondPlayer() {
        return null;
    }

    @Override
    public boolean isGameFinished() {
        return false;
    }

    @Override
    public boolean isSecondPlayerTurn() {
        return false;
    }

    @Override
    public void reset() {

    }

    @Override
    public void undoLastMove() {

    }

    @Override
    public int getBoardSize() {
        return 11;
    }
}