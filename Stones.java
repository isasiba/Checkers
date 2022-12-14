public class Stones extends Piece {

    // creates new Stone (piece thats not a king)
    public Stones(boolean red, int x, int y) {
        super(red, x, y);
    }


    // checks to see if the stone is jumping
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

    }
}
