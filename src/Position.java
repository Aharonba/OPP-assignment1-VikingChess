public class Position {
     int x;
    int y;

    private int soliders_steps =0;

    Position(int x, int y) {
        this.y = y;
        this.x = x;

    }

    public String toString() {
        return  "(" + this.x + "," + this.y + ")";
    }

    public int getSoliders_steps() {
        return soliders_steps;
    }

    public void setSoliders_steps() {
        this.soliders_steps = soliders_steps+1;
    }


    public int getX (){
    return x;
    }

    public int getY (){
        return y;
    }

}
