// The King class is a child of the piece class and it is
// very similar to the stones class, with the only exceptions
// being that it can move in both directions and has a different
// picture displayed
public class King extends Piece {

    // King Constructor, takes in color, x, y, coordinates
    public King(boolean r, int row, int c) {
        super(r, row, c);
    }

    // checks to make sure that the end row (er) and end column(ec) are
    // diagonal from the initial row (ir) and initial column (ic) (but in any direction)
    public boolean id(int ir, int ic, int er, int ec, boolean r) {
        if (Math.abs(er - ir) == 1 && Math.abs(ec - ic) == 1) {
            return true;
        }
        return false;
    }

    // check to see if a move is a jump or not using user input of
    // initial row, initial column, end row, end column, color, and
    // the board they're playing the game on
    public boolean canItJump(int ir, int ic, int er, int ec, boolean r, Board a) {
        if (this.upLeft(ir, ic, er, ec)) {
            int irr = ir + 1;
            int icc = ic - 1;
            if (this.id(ir, ic, irr, icc, r) && a.getSquare(irr, icc).isOccupied()) {
                if (this.id(irr, icc, er, ec, r) && a.getPieceOnSquare(irr, icc).getColor() != r) {
                    return true;
                }
            }
        }
        else if (this.upRight(ir, ic, er, ec)) {
            int irr = ir + 1;
            int icc = ic + 1;
            if (this.id(ir, ic, irr, icc, r) && a.getSquare(irr, icc).isOccupied()) {
                if (this.id(irr, icc, er, ec, r) && a.getPieceOnSquare(irr, icc).getColor() != r) {
                    return true;
                }
            }

        }
        else if (this.downLeft(ir, ic, er, ec)) {
            int irr = ir - 1;
            int icc = ic - 1;
            if (this.id(ir, ic, irr, icc, r) && a.getSquare(irr, icc).isOccupied()) {
                if (this.id(irr, icc, er, ec, r) && a.getPieceOnSquare(irr, icc).getColor() != r) {
                    return true;
                }
            }

        }
        else if (this.downRight(ir, ic, er, ec)) {
            int irr = ir - 1;
            int icc = ic + 1;
            if (this.id(ir, ic, irr, icc, r) && a.getSquare(irr, icc).isOccupied()) {
                if (this.id(irr, icc, er, ec, r) && a.getPieceOnSquare(irr, icc).getColor() != r) {
                    return true;
                }
            }
        }
        return false;
    }

    // returns if this piece is a king or not
    public boolean isKing() {
        return true;
    }

    // used main to test methods
    public static void main(String[] args) {

        // * TEST CODE FOR FUNCTION #2: INHERITANCE *

        // We want to make sure that the King class inherits the
        // properties of the Piece Class so that's what we'll test first
        King a = new King(true, 1, 1);
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
