public abstract class Piece {
    // saves color of piece
    private boolean isred;
    // saves x value of piece (so we know where to display piece)
    private int xValue;
    // saves y value of piece (so we know where to display piece)
    private int yValue;

    // creates new Piece Object
    public Piece(boolean color, int x, int y) {
        isred = color;
        xValue = x;
        yValue = y;
    }

    // returns color of piece
    public boolean getColor() {
        return isred;
    }

    // returns if the piece is moving up and to the right
    public boolean upRight(int ir, int ic, int er, int ec) {
        if (er > ir && ec > ic) {
            return true;
        }
        return false;
    }

    // returns if the piece is moving up and to the left
    public boolean upLeft(int ir, int ic, int er, int ec) {
        if (er > ir && ic > ec) {
            return true;
        }
        return false;
    }

    // returns if the piece is moving down and to the left
    public boolean downLeft(int ir, int ic, int er, int ec) {
        if (er < ir && ec < ic) {
            return true;
        }
        return false;
    }

    // returns if the piece is moving down and to the right
    public boolean downRight(int ir, int ic, int er, int ec) {
        if (er < ir && ec > ic) {
            return true;
        }
        return false;
    }

    // returns x value (used for displaying image)
    public double getxValue() {
        return xValue;
    }

    // returns y value (used for displaying image)
    public double getyValue() {
        return yValue;
    }

    // updates x value
    public void setxValue(int x) {
        xValue = x;
    }

    // updates y value
    public void setyValue(int y) {
        yValue = y;
    }

    // moves piece by assigning it to a new square and "leaving" the old square
    public void move(int ir, int ic, int er, int ec, boolean r, Board a) {
        if (id(ir, ic, er, ec, r)) {
            Square c = a.getSquare(er, ec);
            this.setxValue(c.getX());
            this.setyValue(c.getY());
            c.setPiece(this);
            a.getSquare(ir, ic).leave();
        }
    }

    // allows a piece to jump by moving the piece (see above) and then also
    // having the piece that was "jumped over" leave its current square
    public void jump(int ir, int ic, int er, int ec, Board a) {
        Square c = a.getSquare(er, ec);
        this.setxValue(c.getX());
        this.setyValue(c.getY());
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

    // checks to see if a move is a jump
    public abstract boolean canItJump(int ir, int ic, int er, int ec, boolean r, Board a);

    // checks to see if the piece is moving diagonally
    public abstract boolean id(int ir, int ic, int er, int ec, boolean r);

    // returns if the piece belongs to King class or not
    public abstract boolean isKing();

    public static void main(String[] args) {

    }
}
