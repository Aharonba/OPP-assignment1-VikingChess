import java.util.*;

import static org.junit.Assert.assertTrue;

public class GameLogic implements PlayableLogic {

    private ConcretePiece[][] board;
    private Player player_2 = new ConcretePlayer(true);
    private Player player_1 = new ConcretePlayer(false);
    private boolean turn;
    private Boolean king;

    private Player winner;

    private Boolean game_finish=false;


    private ConcretePiece[] soldiers = new ConcretePiece[37];

    private int step_in_position[][][] = new int[11][11][37];


    GameLogic() {
        reset();
    }

// I add this method:


    public void board_initialization(Piece[][] board) {

        for (int i = 0; i < 24; i++) {
            soldiers[i] = new Pawn(player_2, i + 1);
        }
        for (int j = 0; j < 13; j++) {
            if (j != 6) {
                soldiers[24 + j] = new Pawn(player_1, j + 1);
            }
        }

        soldiers[30] = new King(player_1, 7);
        // player 2:

        board[3][0] = soldiers[0];
        board[4][0] = soldiers[1];
        board[5][0] = soldiers[2];
        board[6][0] = soldiers[3];
        board[7][0] = soldiers[4];
        board[5][1] = soldiers[5];

        board[3][10] = soldiers[19];
        board[4][10] = soldiers[20];
        board[5][10] = soldiers[21];
        board[6][10] = soldiers[22];
        board[7][10] = soldiers[23];
        board[5][9] = soldiers[18];

        board[0][3] = soldiers[6];
        board[0][4] = soldiers[8];
        board[0][5] = soldiers[10];
        board[0][6] = soldiers[14];
        board[0][7] = soldiers[16];
        board[1][5] = soldiers[11];


        board[10][3] = soldiers[7];
        board[10][4] = soldiers[9];
        board[10][5] = soldiers[13];
        board[10][6] = soldiers[15];
        board[10][7] = soldiers[17];
        board[9][5] = soldiers[12];


        //player 1:

        board[5][3] = soldiers[24];
        board[4][4] = soldiers[25];
        board[5][4] = soldiers[26];
        board[6][4] = soldiers[27];
        board[3][5] = soldiers[28];
        board[4][5] = soldiers[29];
        board[5][5] = soldiers[30];
        board[6][5] = soldiers[31];
        board[7][5] = soldiers[32];
        board[4][6] = soldiers[33];
        board[5][6] = soldiers[34];
        board[6][6] = soldiers[35];
        board[5][7] = soldiers[36];


    }


    //check null;
    @Override
    public boolean move(Position a, Position b) {
        if (legalMove(a, b) == true) {
            board[b.x][b.y] = board[a.x][a.y];
            board[a.x][a.y] = null;
            turn = !turn;
            kill(b);
            if (((ConcretePiece) getPieceAtPosition(b)).getStep_history().size() == 0) {
                ((ConcretePiece) getPieceAtPosition(b)).setStep_history(a);
            }
            ((ConcretePiece) getPieceAtPosition(b)).setStep_history(b);
            ((ConcretePiece) getPieceAtPosition(b)).setSquares_move(count_steps(a, b));
            int id = ((ConcretePiece) getPieceAtPosition(b)).getId();
            if (((ConcretePiece) getPieceAtPosition(b)).getOwner() == player_1) {
                id = id + 23;
            }
            step_in_position[b.x][b.y][id - 1] = 1;

            this.game_finish = isGameFinishHelper() ;
            if (game_finish==true){
                Arrays.sort(soldiers, new length_steps_compertor().thenComparingInt(ConcretePiece::getId));
                if (king == false) {
                    for (int i = 0; i < soldiers.length; i++) {
                        if (soldiers[i].getStep_history().size() > 0) {
                            if (soldiers[i].getOwner() == player_2) {
                                System.out.print("A" + soldiers[i].getId() + ":" + "[");
                                for (int j = 0; j < soldiers[i].getStep_history().size(); j++) {
                                    if ((j == soldiers[i].getStep_history().size() - 1)) {
                                        System.out.print(soldiers[i].getStep_history().get(j).toString());
                                    } else {
                                        System.out.print(soldiers[i].getStep_history().get(j).toString() + ", ");
                                    }
                                    if ((j == soldiers[i].getStep_history().size() - 1)) {
                                        System.out.println("]");
                                    }

                                }
                            }


                        }

                    }

                    for (int i = 0; i < soldiers.length; i++) {
                        if (soldiers[i].getStep_history().size() > 0) {
                            if (soldiers[i].getOwner() == player_1) {
                                System.out.print("D" + soldiers[i].getId() + ":" + "[");
                                for (int j = 0; j < soldiers[i].getStep_history().size(); j++) {
                                    if ((j == soldiers[i].getStep_history().size() - 1)) {
                                        System.out.print(soldiers[i].getStep_history().get(j).toString());
                                    } else {
                                        System.out.print(soldiers[i].getStep_history().get(j).toString() + ", ");
                                    }
                                    if ((j == soldiers[i].getStep_history().size() - 1)) {
                                        System.out.println("]");
                                    }

                                }
                            }


                        }

                    }


                } else {


                    for (int i = 0; i < soldiers.length; i++) {
                        if (soldiers[i].getStep_history().size() > 0) {
                            if (soldiers[i].getOwner() == player_1) {
                                System.out.print("D" + soldiers[i].getId() + ":" + "[");
                                for (int j = 0; j < soldiers[i].getStep_history().size(); j++) {
                                    if ((j == soldiers[i].getStep_history().size() - 1)) {
                                        System.out.print(soldiers[i].getStep_history().get(j).toString());
                                    } else {
                                        System.out.print(soldiers[i].getStep_history().get(j).toString() + ", ");
                                    }
                                    if ((j == soldiers[i].getStep_history().size() - 1)) {
                                        System.out.println("]");
                                    }

                                }
                            }


                        }

                    }

                    for (int i = 0; i < soldiers.length; i++) {
                        if (soldiers[i].getStep_history().size() > 0) {
                            if (soldiers[i].getOwner() == player_2) {
                                System.out.print("A" + soldiers[i].getId() + ":" + "[");
                                for (int j = 0; j < soldiers[i].getStep_history().size(); j++) {
                                    if ((j == soldiers[i].getStep_history().size() - 1)) {
                                        System.out.print(soldiers[i].getStep_history().get(j).toString());
                                    } else {
                                        System.out.print(soldiers[i].getStep_history().get(j).toString() + ", ");
                                    }
                                    if ((j == soldiers[i].getStep_history().size() - 1)) {
                                        System.out.println("]");
                                    }

                                }
                            }


                        }

                    }
                }

                for (int i = 0; i < 75; i++) {
                    System.out.print("*");
                }
                System.out.println();


                Comparator<ConcretePiece> primary_comparator = Comparator.comparingInt(ConcretePiece::getEdible_amount).reversed();
                Comparator<ConcretePiece> secondary_comparator = Comparator.comparingInt(ConcretePiece::getId);
                owner_comp third_comparator = new owner_comp();

                Arrays.sort(soldiers, primary_comparator.thenComparing(secondary_comparator).thenComparing(third_comparator));

                for (int i = 0; i < soldiers.length; i++) {
                    if (soldiers[i].getEdible_amount() > 0) {
                        if (soldiers[i].getOwner() == player_2) {
                            System.out.print("A" + soldiers[i].getId() + ":" + " " + soldiers[i].getEdible_amount() + " " + "kills");
                        }
                        if (soldiers[i].getOwner() == player_1) {
                            System.out.print("D" + soldiers[i].getId() + ":" + " " + soldiers[i].getEdible_amount() + " " + "kills");
                        }
                        System.out.println();

                    }
                }
                for (int i = 0; i < 75; i++) {
                    System.out.print("*");
                }
                System.out.println();


                Comparator<ConcretePiece> primaryComp = Comparator.comparingInt(ConcretePiece::getSquares_move).reversed();
                Comparator<ConcretePiece> secondaryComp = Comparator.comparing(ConcretePiece::getId);
                Arrays.sort(soldiers, primaryComp.thenComparing(secondaryComp).thenComparing(third_comparator));

                for (int i = 0; i < soldiers.length; i++) {
                    if (soldiers[i].getSquares_move() > 0) {

                        if (soldiers[i].getOwner() == player_2) {
                            System.out.println("A" + soldiers[i].getId() + ":" + soldiers[i].getSquares_move() + " " + "squares");
                        }
                        if (soldiers[i].getOwner() == player_1) {
                            System.out.println("D" + soldiers[i].getId() + ":" + soldiers[i].getSquares_move() + " " + "squares");
                        }

                    }
                }
                for (int i = 0; i < 75; i++) {
                    System.out.print("*");
                }
                System.out.println();


                Position[] positionArrayList = new Position[121];
                int x = 0;
                int y = 0;
                int track = 0;
                for (int i = 0; i < 121; i++) {
                    positionArrayList[i] = new Position(x, y);

                    for (int j = 0; j < 37; j++) {
                        if (step_in_position[positionArrayList[i].x][positionArrayList[i].y][j] == 1) {
                            positionArrayList[i].setSoliders_steps();
                        }
                    }
                    x++;
                    track++;
                    if (x > 10) {
                        y++;
                        x = 0;
                    }

                }


                Comparator<Position> primaryCo = Comparator.comparingInt(Position::getSoliders_steps);
                Comparator<Position> secondaryCo = Comparator.comparingInt(Position::getX);
                Comparator<Position> thirdCo = Comparator.comparingInt(Position::getY);
                Arrays.sort(positionArrayList, primaryCo.thenComparing(secondaryCo).thenComparing(thirdCo));

                for (int i = 0; i < positionArrayList.length; i++) {
                    if (positionArrayList[i].getSoliders_steps() > 0) {
                        System.out.println("(" + positionArrayList[i].getX() + "," + " " + positionArrayList[i].getY() + ")" + positionArrayList[i].getSoliders_steps() + " " + "pieces");
                    }
                }

            }



            return true;
        } else return false;

    }

    public boolean legalMove(Position a, Position b) {

        if (board[a.x][a.y].piece_owner.isPlayerOne() == turn || !(board[a.x][a.y].piece_owner.isPlayerOne()) != turn) {
            return false;
        }

        if (its_Corner(b)) {
            if (board[a.x][a.y] instanceof Pawn) {
                return false;
            }
        }

        // checking move direction
        if (a.y != b.y && a.x != b.x) {
            return false;
        }

        //checking b is null
        if (board[b.x][b.y] != null) {
            return false;
        }

        //checking the col/row
        if (a.x == b.x && a.y < b.y) {
            for (int i = (a.y) + 1; i < b.y; i++) {
                if (board[a.x][i] != null) {
                    return false;
                }

            }
        }


        if (a.x == b.x && a.y > b.y) {
            for (int i = (a.y) - 1; i > b.y; i--) {
                if (board[a.x][i] != null) {
                    return false;
                }

            }
        }


        if (a.y == b.y && a.x < b.x) {
            for (int i = (a.x) + 1; i < b.x; i++) {
                if (board[i][a.y] != null) {
                    return false;
                }

            }
        }


        if (a.y == b.y && a.x > b.x) {
            for (int i = (a.x) - 1; i > b.x; i--) {
                if (board[i][a.y] != null) {
                    return false;
                }

            }
        }


        return true;
    }


    @Override
    public Piece getPieceAtPosition(Position position) {

        return board[position.x][position.y];
    }

    @Override
    public Player getFirstPlayer() {
        return player_1;
    }

    @Override
    public Player getSecondPlayer() {
        return player_2;
    }

    @Override
    public boolean isGameFinished() {
      return  isGameFinishHelper();
    }


    @Override
    public boolean isSecondPlayerTurn() {
        return turn;
    }

    @Override
    public void reset() {
        turn = true;
        board = new ConcretePiece[11][11];
        board_initialization(board);
        king = true;
    }

    @Override
    public void undoLastMove() {

    }

    @Override
    public int getBoardSize() {
        return 11;
    }


    public Boolean its_Corner(Position position) {
        if (((position.y == 0) && (position.x == 0)) || ((position.x == 0) && (position.y == 10)) || ((position.x == 10) && (position.y == 0)) || ((position.x == 10) && (position.y == 10))) {
            return true;
        }

        return false;
    }


    public void kill(Position position) {

        //create an array to check all sides

        Position[] sides = new Position[8];
        sides[0] = new Position(position.x, position.y + 1);
        sides[1] = new Position(position.x, position.y + 2);
        sides[2] = new Position(position.x - 1, position.y);
        sides[3] = new Position(position.x - 2, position.y);
        sides[4] = new Position(position.x, position.y - 1);
        sides[5] = new Position(position.x, position.y - 2);
        sides[6] = new Position(position.x + 1, position.y);
        sides[7] = new Position(position.x + 2, position.y);

        if (getPieceAtPosition(position) instanceof Pawn) {
            for (int i = 0; i < sides.length; i = i + 2) {
                Position middle = sides[i];
                Position last = sides[i + 1];
                if (inRange(middle)) {
                    if (getPieceAtPosition(middle) instanceof Pawn) {
                        if (checkMiddle(middle, position) && checkLast(last, position)) {
                            ((Pawn) getPieceAtPosition(position)).setEdible_amount();
                            board[middle.x][middle.y] = null;
                        }


                    }
                    if (getPieceAtPosition(middle) instanceof King) {
                        Position up_middle = new Position(middle.x, middle.y - 1);
                        Position down_middle = new Position(middle.x, middle.y + 1);
                        Position left_middle = new Position(middle.x - 1, middle.y);
                        Position right_middle = new Position(middle.x + 1, middle.y);
                        if (checkLast(up_middle, position) && checkLast(down_middle, position) && checkLast(left_middle, position) && checkLast(right_middle, position)) {
                            ((Pawn) getPieceAtPosition(position)).setEdible_amount();
                            board[middle.x][middle.y] = null;
                            king = false;
                            winner = player_2;
                        }

                    }

                }

            }
        }

    }

    private boolean inRange(Position p) {
        return (p.x >= 0 && p.x < 11 && p.y >= 0 && p.y < 11);
    }


    private Boolean checkMiddle(Position middle, Position position) {


        if (!inRange(middle) || getPieceAtPosition(middle) == null || getPieceAtPosition(middle).getOwner() == getPieceAtPosition(position).getOwner()) {
            return false;
        }
        return true;
    }


    private Boolean checkLast(Position last, Position position) {
        if (inRange(last)) {
            if (getPieceAtPosition(last) == null || getPieceAtPosition(last).getOwner() != getPieceAtPosition(position).getOwner()
                    || (getPieceAtPosition(last) instanceof King)) {
                return false;
            }
        }
        return true;
    }


    public class length_steps_compertor implements Comparator<ConcretePiece> {

        @Override
        public int compare(ConcretePiece a, ConcretePiece b) {
            return Integer.compare(a.getStep_history().size(), b.getStep_history().size());
        }
    }

    public class edibleComp implements Comparator<ConcretePiece> {


        public int compare(ConcretePiece a, ConcretePiece b) {
            return Integer.compare(b.getEdible_amount(), a.getEdible_amount());
        }

    }

//    public class CompositeComparator implements Comparator<ConcretePiece> {
//        private Comparator<ConcretePiece> primaryComparator;
//        private Comparator<ConcretePiece> secondaryComparator;
//
//        public CompositeComparator(Comparator<ConcretePiece> primaryComparator, Comparator<ConcretePiece> secondaryComparator) {
//            this.primaryComparator = primaryComparator;
//            this.secondaryComparator = secondaryComparator;
//        }
//
//        public int compare(ConcretePiece a, ConcretePiece b) {
//
//            int result = primaryComparator.compare(b, a);
//            if (result == 0) {
//                return secondaryComparator.compare(a, b);
//
//            }
//            return result;
//        }
//
//    }


//    public class ownerComp implements Comparator<ConcretePiece> {
//
//        @Override
//        public int compare(ConcretePiece a, ConcretePiece b) {
//            ConcretePlayer first = (ConcretePlayer) a.getOwner(); // true
//            ConcretePlayer second = (ConcretePlayer) b.getOwner(); // false
//            if (king == false && b.getOwner() == player_2) {
//                return Boolean.compare(second.isSide(), first.isSide());
//            } else if (king == false && b.getOwner() == player_1) {
//                return Boolean.compare(first.isSide(), second.isSide());
//            } else if (king == true && b.getOwner() == player_2) {
//
//                return Boolean.compare(second.isSide(), first.isSide());
//            } else if (king == true && b.getOwner() == player_1) {
//
//                return Boolean.compare(first.isSide(), second.isSide());
//            }
//            return 0;
//        }
//    }

    public int count_steps(Position a, Position b) {
        int tmp = ((ConcretePiece) getPieceAtPosition(b)).getSquares_move();
        if (a.x == b.x) {
            return Math.abs(b.y - a.y) + tmp;
        } else {
            return Math.abs(b.x - a.x) + tmp;
        }
    }

    private class owner_comp implements Comparator<ConcretePiece> {


        @Override
        public int compare(ConcretePiece o1, ConcretePiece o2) {
            if (o1.getOwner() == winner) {
                return -1;
            }
            return 1;
        }
    }


    public static int calculateLastArraySum(int[][][] threeDArray) {
        int sum = 0;

        // Get the dimensions of the 3D array
        int depth = threeDArray.length;
        int row = threeDArray[0].length;
        int col = threeDArray[0][0].length;

        // Iterate over the elements of the last array and calculate the sum
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    // Add the value to the sum
                    sum += threeDArray[i][j][k];
                }
            }
        }

        return sum;
    }

    public boolean isGameFinishHelper(){
        if (king == true) {
            winner = player_1;
        }
        if (board[0][10] instanceof King || board[10][0] instanceof King || board[0][0] instanceof King || board[10][10] instanceof King || !king) {

            return true;
        }


        return false;


    }

}


