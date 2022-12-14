public class King extends Piece {

    // King Constructor
    public King(boolean r, int row, int c) {
        super(r, row, c);
    }

    // checks to make sure that the end row (er) and end column(ec) are
    // diagonal from the king (but in any direction)
    public boolean id(int ir, int ic, int er, int ec, boolean r) {
        if (Math.abs(er - ir) == 1 && Math.abs(ec - ic) == 1) {
            return true;
        }
        return false;
    }

    // check to see if a move is a jump or not using user input of
    // intital row, intial column, end row, end column, and color
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
