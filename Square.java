public class Square {
    // returns if the square has a piece on it
    private boolean occupied;
    // returns piece on square
    private Piece a;
    // returns color of square
    private boolean red;
    // returns x value of square (where image is centered)
    private int x;
    // returns y value of square (where image is centered)
    private int y;

    // creates empty Square
    public Square(boolean isred, int xx, int yy) {
        occupied = false;
        red = isred;
        x = xx;
        y = yy;
    }

    // creates Square with Piece (which it takes in as a paramter)
    public Square(Piece p, boolean isred, int xx, int yy) {
        this.a = p;
        red = isred;
        occupied = true;
        x = xx;
        y = yy;
    }

    // returns if the square is occupied or not
    public boolean isOccupied() {
        return occupied;
    }

    // returns piece on square
    public Piece getPiece() {
        return this.a;
    }

    // returns color of square
    public boolean getColor() {
        return red;
    }

    // returns x value of square (used to draw image)
    public int getX() {
        return x;
    }

    // returns y value of square (used to draw image)
    public int getY() {
        return y;
    }

    // assigns a new piece to Square
    public void setPiece(Piece p) {
        a = p;
        occupied = true;
    }

    // sets square as unoccupied when a piece "leaves" the square
    public void leave() {
        occupied = false;
    }

    public static void main(String[] args) {

    }
}
