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


    public static void main(String[] args) {

    }
}
