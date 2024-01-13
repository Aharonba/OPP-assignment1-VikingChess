public class ConcretePlayer implements Player {
    private boolean side;
    private int number_of_wining;

    ConcretePlayer(boolean side) {

        this.side = side;
    }

    public boolean isPlayerOne() {
        if (side == true) {
            return true;
        }

        return false;
    }


    public int getWins() {

        return number_of_wining;
    }


    public boolean isSide() {
        return side;
    }

    public void setSide(boolean side) {
        this.side = side;
    }
}
