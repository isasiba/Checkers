// The Stones class is a child of the Piece class and represents a checker piece
// that has yet to become kinged. These pieces are known as "stones", hence the class name
public class Stones extends Piece {

    // creates new Stone with given color and position
    public Stones(boolean red, int x, int y) {
        super(red, x, y);
    }


    // checks to see if the stone is jumping based off of initial and end location,
    // color, and the gameboard the game is currently being played on
    public boolean canItJump(int ir, int ic, int er, int ec, boolean r, Board a) {
        if (this.upLeft(ir, ic, er, ec) && r) {
            int irr = ir + 1;
            int icc = ic - 1;
            if (this.id(ir, ic, irr, icc, r) && a.getSquare(irr, icc).isOccupied()) {
                if (this.id(irr, icc, er, ec, r) && !a.getPieceOnSquare(irr, icc).getColor()) {
                    return true;
                }
            }
        }
        else if (this.upRight(ir, ic, er, ec) && r) {
            int irr = ir + 1;
            int icc = ic + 1;
            if (this.id(ir, ic, irr, icc, r) && a.getSquare(irr, icc).isOccupied()) {
                if (this.id(irr, icc, er, ec, r) && !a.getPieceOnSquare(irr, icc).getColor()) {
                    return true;
                }
            }

        }
        else if (this.downLeft(ir, ic, er, ec) && !r) {
            int irr = ir - 1;
            int icc = ic - 1;
            if (this.id(ir, ic, irr, icc, r) && a.getSquare(irr, icc).isOccupied()) {
                if (this.id(irr, icc, er, ec, r) && a.getPieceOnSquare(irr, icc).getColor()) {
                    return true;
                }
            }

        }
        else if (this.downRight(ir, ic, er, ec) && !r) {
            int irr = ir - 1;
            int icc = ic + 1;
            if (this.id(ir, ic, irr, icc, r) && a.getSquare(irr, icc).isOccupied()) {
                if (this.id(irr, icc, er, ec, r) && a.getPieceOnSquare(irr, icc).getColor()) {
                    return true;
                }
            }
        }
        return false;
    }

    // checks to see if the piece is moving diagonally in a valid direction
    // using initial and end positions
    // for example, red stones can only move up
    // and black stones can only move down the board
    public boolean id(int ir, int ic, int er, int ec, boolean r) {
        if (r) {
            if (er - ir == 1 && Math.abs(ec - ic) == 1) {
                return true;
            }
        }
        else {
            if (er - ir == -1 && Math.abs(ec - ic) == 1) {
                return true;
            }
        }
        return false;
    }

    // returns that it is a stone, not a king
    public boolean isKing() {
        return false;
    }

    public static void main(String[] args) {
        // * TEST CODE FOR FUNCTION #2: INHERITANCE *

        // We want to make sure that the King class inherits the
        // properties of the Piece Class so that's what we'll test first
        Stones a = new Stones(true, 1, 1);
        StdOut.println(a.getColor());
        StdOut.println(a.getxValue());
        StdOut.println(a.getyValue());
        a.setxValue(2);
        a.setyValue(23);
        StdOut.println(a.getxValue());
        StdOut.println(a.getyValue());
        StdOut.println(a.upRight(1, 1, 2, 23));
        StdOut.println(a.upRight(5, 1, 2, 23));
        StdOut.println(a.upLeft(1, 1, 0, 23));
        StdOut.println(a.upLeft(5, 1, 2, 23));
        StdOut.println(a.downLeft(10, 12, 2, 2));
        StdOut.println(a.downLeft(5, 1, 2, 23));
        StdOut.println(a.downRight(10, 12, 2, 2));
        StdOut.println(a.downRight(5, 1, 2, 23));
        // to save time, we tested the other two non-abstract methods in the
        // piece class (move and jump) in the game class using command line
        // arguments and the cases we tested were:
        // to make sure that they didn't fail were moving out of bounds, to places
        // a king shouldn't be able to move, moving multiple pieces to the same
        // square, and then checking that when jumped, the square of the piece
        // captured was empty

        // Now, we can test the abstract methods
        StdOut.println(a.isKing());
        StdOut.println(a.id(0, 1, 0, 2, a.getColor()));
        StdOut.println(a.id(0, 1, 5, 7, a.getColor()));

        // we also tested canItJump in the game class by calling jumps
        // close to the edge of the board, jumping backwards and forwards,
        // jumping over your own pieces, etc.
    }
}
