public class Square {
    private boolean occupied;
    private Piece a;
    private boolean red;
    private int x;
    private int y;

    public Square(boolean isred, int xx, int yy) {
        occupied = false;
        red = isred;
        x = xx;
        y = yy;
    }

    public Square(Piece p, boolean isred, int xx, int yy) {
        this.a = p;
        red = isred;
        occupied = true;
        x = xx;
        y = yy;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public Piece getPiece() {
        return this.a;
    }

    public boolean getColor() {
        return red;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPiece(Piece p) {
        a = p;
        occupied = true;
    }

    public void leave() {
        occupied = false;
    }

    public static void main(String[] args) {

    }
}
