public class King extends Piece {
    private int xvalue;
    private int yvalue;

    public King(boolean r, int row, int c) {
        super(r);
        xvalue = row;
        yvalue = c;
    }

    public boolean move(int ir, int ic, int er, int ec, boolean r, Board a) {
        return true;
    }

    public boolean canItMoveThere(int ir, int ic, int er, int ec, boolean r, Board a) {
        return true;
    }

    public boolean id(int ir, int ic, int er, int ec, boolean r) {
        return true;
    }

    public boolean canItJump(int ir, int ic, int er, int ec, boolean r, Board a) {
        if (r) {
            if (Math.abs(er - ir) == 2 && Math.abs(ec - ic) == 2 && ec >= 0 && er < 8
                    && ec < 8 && er >= 0) {
                if (ec < ic) {
                    if (a.getSquare(ec + 1, er - 1).getPiece().getColor() != r) {
                        a.getSquare(ec + 1, er - 1).leave();
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
            if (Math.abs(er - ir) == 2 && Math.abs(ec - ic) == 2 && ec >= 0 && er >= 0
                    && ec < 8 && er < 8) {
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

    public double getXvalue() {
        return xvalue;
    }

    public double getYvalue() {
        return yvalue;
    }

    public boolean isKing() {
        return true;
    }

    public static void main(String[] args) {

    }
}
