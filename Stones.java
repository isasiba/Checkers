public class Stones extends Piece {
    private int xvalue;
    private int yvalue;

    public Stones(boolean red, int x, int y) {
        super(red);
        xvalue = x;
        yvalue = y;
    }

    public void move(int ir, int ic, int er, int ec, boolean r, Board a) {
        if (canItMoveThere(ir, ic, er, ec, r, a)) {
            Square c = a.getSquare(er, ec);
            xvalue = c.getX();
            yvalue = c.getY();
            c.setPiece(this);
            a.getSquare(ir, ic).leave();
        }
    }

    public void jump(int ir, int ic, int er, int ec, boolean r, Board a) {
        Square c = a.getSquare(er, ec);
        Square d = a.getSquare(ec + 1, er - 1);
        xvalue = c.getX();
        yvalue = c.getY();
        c.setPiece(this);
        a.getSquare(ir, ic).leave();
        System.out.println(d.isOccupied());
        d.leave();
        System.out.println(d.isOccupied());
    }


    public boolean canItJump(int ir, int ic, int er, int ec, boolean r, Board a) {
        if (r) {
            if (er - ir == 2 && Math.abs(ec - ic) == 2 && ec >= 0 && er < 8
                    && ec < 8) {
                if (ec < ic) {
                    if (a.getSquare(ec + 1, er - 1).getPiece().getColor() != r) {
                        StdOut.println("Entered line 38");
                        return true;
                    }
                }
                else {
                    if (a.getSquare(ec + 1, er + 1).getPiece().getColor() != r) {
                        a.getSquare(ec + 1, er + 1).leave();
                        return true;
                    }
                }
            }
        }
        else {
            if (er - ir == -2 && Math.abs(ec - ic) == 2 && ec >= 0 && er >= 0
                    && ec < 8) {
                if (ec < ic) {
                    if (a.getSquare(ec - 1, er - 1).getPiece().getColor() != r) {
                        a.getSquare(ec - 1, er - 1).leave();
                        return true;
                    }
                }
                else {
                    if (a.getSquare(ec + 1, er - 1).getPiece().getColor() != r) {
                        a.getSquare(ec + 1, er - 1).leave();
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

    public boolean canItMoveThere(int ix, int iy, int ex, int ey, boolean r, Board a) {
        if ((ix > 7 || ix < 0) || (iy > 7 || iy < 0) || (ey > 7 || ey < 0) || (ex > 7 || ex < 0)) {
            throw new IllegalArgumentException("Not a valid square");
        }
        if (!a.getSquare(ex, ey).isOccupied() && (!a.getSquare(ex, ey).getColor()) &&
                this.id(ix, iy, ex, ey, r)) {
            return true;
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
