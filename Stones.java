public class Stones extends Piece {
    private int xvalue;
    private int yvalue;

    public Stones(boolean red, int x, int y) {
        super(red);
        xvalue = x;
        yvalue = y;
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

    public void jump(int ir, int ic, int er, int ec, boolean r, Board a) {
        Square c = a.getSquare(er, ec);
        xvalue = c.getX();
        yvalue = c.getY();
        c.setPiece(this);
        a.getSquare(ir, ic).leave();
        if (this.upLeft(ir, ic, er, ec)) {
            Square d = a.getSquare(er - 1, ec + 1);
            d.leave();
        }
        else if (this.upRight(ir, ic, er, ec)) {
            Square d = a.getSquare(er - 1, ec - 1);
            d.leave();
        }
        else if (this.downLeft(ir, ic, er, ec)) {
            Square d = a.getSquare(ec + 1, er + 1);
            d.leave();
        }
        else {
            Square d = a.getSquare(ec - 1, er + 1);
            d.leave();
        }

    }


    public boolean canItJump(int ir, int ic, int er, int ec, boolean r, Board a) {
        if (r) {
            if (er - ir == 2 && Math.abs(ec - ic) == 2 && ec > 0 && er < 8
                    && ec < 8 && er > 0) {
                // move left
                if (ec < ic) {
                    if (a.getSquare(er - 1, ec + 1).getPiece().getColor() != r) {
                        return true;
                    }
                }
                // move right
                else {
                    if (a.getSquare(er - 1, ec - 1).getPiece().getColor() != r) {
                        return true;
                    }
                }
            }
        }
        else {
            if (er - ir == -2 && Math.abs(ec - ic) == 2 && ec >= 0 && er >= 0
                    && ec < 8) {
                if (ec < ic) {
                    if (a.getSquare(ec + 1, er + 1).getPiece().getColor() != r) {
                        return true;
                    }
                }
                else {
                    if (a.getSquare(ec - 1, er + 1).getPiece().getColor() != r) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

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

    public double getXvalue() {
        return xvalue;
    }

    public double getYvalue() {
        return yvalue;
    }

    public boolean isKing() {
        return false;
    }

    public static void main(String[] args) {

    }
}
