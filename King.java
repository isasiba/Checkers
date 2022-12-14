public class King extends Piece {
    private int xvalue;
    private int yvalue;

    public King(boolean r, int row, int c) {
        super(r);
        xvalue = row;
        yvalue = c;
    }

    public void move(int ir, int ic, int er, int ec, boolean r, Board a) {
        if (id(ir, ic, er, ec, r)) {
            Square c = a.getSquare(er, ec);
            xvalue = c.getX();
            yvalue = c.getY();
            c.setPiece(this);
            a.getSquare(ir, ic).leave();
        }
    }

    public boolean id(int ir, int ic, int er, int ec, boolean r) {
        if (Math.abs(er - ir) == 1 && Math.abs(ec - ic) == 1) {
            return true;
        }
        return false;
    }

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

    public double getXvalue() {
        return xvalue;
    }

    public double getYvalue() {
        return yvalue;
    }

    public boolean isKing() {
        return true;
    }

    public void jump(int ir, int ic, int er, int ec, boolean r, Board a) {
        Square c = a.getSquare(er, ec);
        xvalue = c.getX();
        yvalue = c.getY();
        c.setPiece(this);
        a.getSquare(ir, ic).leave();
        if (this.upLeft(ir, ic, er, ec)) {
            Square d = a.getSquare(ir + 1, ic - 1);
            d.leave();
        }
        else if (this.upRight(ir, ic, er, ec)) {
            Square d = a.getSquare(ir + 1, ic + 1);
            d.leave();
        }
        else if (this.downLeft(ir, ic, er, ec)) {
            Square d = a.getSquare(ir - 1, ic - 1);
            d.leave();
        }
        else {
            Square d = a.getSquare(ir - 1, ic + 1);
            d.leave();
        }

    }

    public static void main(String[] args) {

    }
}
