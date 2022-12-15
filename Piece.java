// Creates the Piece Class, which is the Parent Class to the "Stones"
// and "King" classes. This class is abstract because the implementations
// of some methods differ between the Stones and King classes
public abstract class Piece {
    // saves color of piece
    private boolean isred;
    // saves x value of piece (so we know where to display piece)
    private int xValue;
    // saves y value of piece (so we know where to display piece)
    private int yValue;

    // creates new Piece Object by assigning it a color, x, and y value
    public Piece(boolean color, int x, int y) {
        isred = color;
        xValue = x;
        yValue = y;
    }

    // returns color of piece
    public boolean getColor() {
        return isred;
    }

    // returns if the piece is moving up and to the right by looking
    // at the initial row, initial column, end row, and end column
    public boolean upRight(int ir, int ic, int er, int ec) {
        if (er > ir && ec > ic) {
            return true;
        }
        return false;
    }

    // returns if the piece is moving up and to the left by looking
    // at the initial row, initial column, end row, and end column
    public boolean upLeft(int ir, int ic, int er, int ec) {
        if (er > ir && ic > ec) {
            return true;
        }
        return false;
    }

    // returns if the piece is moving down and to the left by looking
    // at the initial row, initial column, end row, and end column
    public boolean downLeft(int ir, int ic, int er, int ec) {
        if (er < ir && ec < ic) {
            return true;
        }
        return false;
    }

    // returns if the piece is moving down and to the right by looking
    // at the initial row, initial column, end row, and end column
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

    // updates x value to int taken in
    public void setxValue(int x) {
        xValue = x;
    }

    // updates y value to int taken in
    public void setyValue(int y) {
        yValue = y;
    }

    // moves piece by assigning it to a new square and "leaving" the old square
    // this happens by first checking that its a valid diagonal move
    // then the current piece is assigned to the new square and "leaves"
    // the old square. This is all accomplished by using  the initial row,
    // initial column, end row, end column, color (to check its moving in right direction),
    // and the board the game is being played on
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
    // This is all accomplished by using the initial row,
    // initial column, end row, end column, color (to check its moving in right direction),
    // the board the game is being played on, and the player doing the jumping
    // (which we use to keep track of # of captured pieces)
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

    // determines if the game is over by checking to see if there are any
    // possible moves a specified piece can make on the specified game board
    public boolean availableMove(int ir, int ic, boolean color, Board a) {
        // red stone
        if (color && !this.isKing()) {
            if (ic == 0) {
                if (!a.getSquare(ir + 1, ic + 1).isOccupied()) {
                    return true;
                }
            }
            else if (ic == 7) {
                if (!a.getSquare(ir + 1, ic - 1).isOccupied()) {
                    return true;
                }
            }
            else {
                if (!a.getSquare(ir + 1, ic - 1).isOccupied() ||
                        !a.getSquare(ir + 1, ic + 1).isOccupied()) {
                    return true;
                }
            }
        }

        // black stone
        else if (!color && !this.isKing()) {
            if (ic == 0) {
                if (!a.getSquare(ir - 1, ic + 1).isOccupied()) {
                    return true;
                }
            }
            else if (ic == 7) {
                if (!a.getSquare(ir - 1, ic - 1).isOccupied()) {
                    return true;
                }
            }
            else {
                if (!a.getSquare(ir - 1, ic - 1).isOccupied() ||
                        !a.getSquare(ir - 1, ic + 1).isOccupied()) {
                    return true;
                }
            }
        }

        // king
        else {
            if (ic == 0) {
                if (!a.getSquare(ir + 1, ic + 1).isOccupied() ||
                        !a.getSquare(ir - 1, ic + 1).isOccupied()) {
                    return true;
                }
            }
            else if (ic == 7) {
                if (!a.getSquare(ir + 1, ic - 1).isOccupied() ||
                        !a.getSquare(ir - 1, ic - 1).isOccupied()) {
                    return true;
                }
            }
            else if (ir == 0) {
                if (!a.getSquare(ir + 1, ic - 1).isOccupied() ||
                        !a.getSquare(ir + 1, ic + 1).isOccupied()) {
                    return true;
                }
            }
            else if (ir == 7) {
                if (!a.getSquare(ir - 1, ic - 1).isOccupied() ||
                        !a.getSquare(ir - 1, ic + 1).isOccupied()) {
                    return true;
                }
            }
            else {
                if (!a.getSquare(ir + 1, ic - 1).isOccupied() ||
                        !a.getSquare(ir + 1, ic + 1).isOccupied()
                        || !a.getSquare(ir - 1, ic - 1).isOccupied()
                        || !a.getSquare(ir - 1, ic + 1).isOccupied()) {
                    return true;
                }
            }
        }
        return false;
    }

    // determines if the game is over by checking to see if there are any
    // possible moves a specified piece can make on the specified game board
    public boolean availableJump(int ir, int ic, boolean color, Board a) {
        // red stone
        if (color && !this.isKing()) {
            if (ir == 6) {
                return false;
            }
            else if (ic == 0 || ic == 1) {
                if (this.canItJump(ir, ic, ir + 2, ic + 2, color, a)) {
                    return true;
                }
            }
            else if (ic == 7 || ic == 6) {
                if (this.canItJump(ir, ic, ir + 2, ic - 2, color, a)) {
                    return true;
                }
            }
            else {
                if (this.canItJump(ir, ic, ir + 2, ic + 2, color, a) ||
                        this.canItJump(ir, ic, ir + 2, ic - 2, color, a)) {
                    return true;
                }
            }
        }

        // black stone
        else if (!color && !this.isKing()) {
            if (ir == 1) {
                return false;
            }
            else if (ic == 0 || ic == 1) {
                if (this.canItJump(ir, ic, ir - 2, ic + 2, color, a)) {
                    return true;
                }
            }
            else if (ic == 7 || ic == 6) {
                if (this.canItJump(ir, ic, ir - 2, ic - 2, color, a)) {
                    return true;
                }
            }
            else {
                if (this.canItJump(ir, ic, ir - 2, ic + 2, color, a) ||
                        this.canItJump(ir, ic, ir - 2, ic - 2, color, a)) {
                    return true;
                }
            }
        }

        // kings
        else {
            if ((ir == 0 && ic == 1) || (ir == 1 && ic == 0)) {
                if (this.canItJump(ir, ic, ir + 2, ic + 2, color, a)) {
                    return true;
                }
            }
            else if ((ir == 0 && ic == 7) || (ir == 1 && ic == 6)) {
                if (this.canItJump(ir, ic, ir + 2, ic - 2, color, a)) {
                    return true;
                }
            }
            else if ((ir == 6 && ic == 1) || (ir == 7 && ic == 0)) {
                if (this.canItJump(ir, ic, ir - 2, ic + 2, color, a)) {
                    return true;
                }
            }
            else if ((ir == 6 && ic == 7) || (ir == 7 && ic == 6)) {
                if (this.canItJump(ir, ic, ir - 2, ic - 2, color, a)) {
                    return true;
                }
            }
            else if ((ir == 0 && (ic == 3 || ic == 5))
                    || (ir == 1 && (ic == 2 || ic == 4))) {
                if (this.canItJump(ir, ic, ir + 2, ic - 2, color, a)
                        || this.canItJump(ir, ic, ir + 2, ic + 2, color, a)) {
                    return true;
                }
            }
            else if ((ic == 0 && (ir == 3 || ir == 5))
                    || (ic == 1 && (ir == 2 || ir == 4))) {
                if (this.canItJump(ir, ic, ir + 2, ic + 2, color, a)
                        || this.canItJump(ir, ic, ir - 2, ic + 2, color, a)) {
                    return true;
                }
            }
            else if ((ic == 6 && (ir == 3 || ir == 5))
                    || (ic == 7 && (ir == 2 || ir == 4))) {
                if (this.canItJump(ir, ic, ir + 2, ic - 2, color, a)
                        || this.canItJump(ir, ic, ir - 2, ic - 2, color, a)) {
                    return true;
                }
            }
            else if ((ir == 6 && (ic == 3 || ic == 5))
                    || (ir == 7 && (ic == 2 || ic == 4))) {
                if (this.canItJump(ir, ic, ir - 2, ic + 2, color, a)
                        || this.canItJump(ir, ic, ir - 2, ic - 2, color, a)) {
                    return true;
                }
            }
            else {
                if (this.canItJump(ir, ic, ir - 2, ic + 2, color, a)
                        || this.canItJump(ir, ic, ir - 2, ic - 2, color, a)
                        || this.canItJump(ir, ic, ir + 2, ic - 2, color, a)
                        || this.canItJump(ir, ic, ir + 2, ic + 2, color, a)) {
                    return true;
                }
            }

        }
        return false;
    }

    // checks to see if a move is a jump using the initial row,
    // initial column, end row, end column, color (to check its moving in right direction),
    // and the board the game is being played on
    public abstract boolean canItJump(int ir, int ic, int er, int ec, boolean r, Board a);

    // checks to see if the piece is moving diagonally using the initial row,
    // initial column, end row, end column, color (to check its moving in right direction),
    // and the board the game is being played on
    public abstract boolean id(int ir, int ic, int er, int ec, boolean r);

    // returns if the piece belongs to King class or not
    public abstract boolean isKing();

    public static void main(String[] args) {

    }
}
