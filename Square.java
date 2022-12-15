// The Square class creates a Square object that can then be assigned
// various properties like color or pieces which are then used to play
public class Square {
    // returns if the square has a piece on it
    private boolean occupied;
    // returns piece on square
    private Piece a;
    // returns color of square
    private boolean red;
    // returns x value of square (where image is centered)
    private int x;
    // returns y value of square (where image is centered)
    private int y;

    // creates empty Square with specified color and position
    public Square(boolean isred, int xx, int yy) {
        occupied = false;
        red = isred;
        x = xx;
        y = yy;
    }

    // creates Square with Piece, color, and position (which are taken in)
    public Square(Piece p, boolean isred, int xx, int yy) {
        a = p;
        red = isred;
        occupied = true;
        x = xx;
        y = yy;
    }

    // returns if the square is occupied or not
    public boolean isOccupied() {
        return occupied;
    }

    // returns piece on square
    public Piece getPiece() {
        return a;
    }

    // returns color of square
    public boolean getColor() {
        return red;
    }

    // returns x value of square (used to draw image)
    public int getX() {
        return x;
    }

    // returns y value of square (used to draw image)
    public int getY() {
        return y;
    }

    // assigns piece taken in to Square
    public void setPiece(Piece p) {
        a = p;
        occupied = true;
    }

    // sets square as unoccupied when a piece "leaves" the square
    public void leave() {
        occupied = false;
    }

    // determines if the game is over by checking to see if there are any
    // possible moves a specified piece can make on the specified game board
    public boolean availableMove(Piece p, int ir, int ic, boolean color, Board aa) {
        // red stone
        if (color && !p.isKing()) {
            if (ir == 7) {
                aa.update();
            }
            else if (ic == 0) {
                if (!aa.getSquare(ir + 1, ic + 1).isOccupied()) {
                    return true;
                }
            }
            else if (ic == 7) {
                if (!aa.getSquare(ir + 1, ic - 1).isOccupied()) {
                    return true;
                }
            }
            else {
                if (!aa.getSquare(ir + 1, ic - 1).isOccupied() ||
                        !aa.getSquare(ir + 1, ic + 1).isOccupied()) {
                    return true;
                }
            }
        }

        // black stone
        else if (!color && !p.isKing()) {
            if (ir == 0) {
                aa.update();
            }
            else if (ic == 0) {
                if (!aa.getSquare(ir - 1, ic + 1).isOccupied()) {
                    return true;
                }
            }
            else if (ic == 7) {
                if (!aa.getSquare(ir - 1, ic - 1).isOccupied()) {
                    return true;
                }
            }
            else {
                if (!aa.getSquare(ir - 1, ic - 1).isOccupied() ||
                        !aa.getSquare(ir - 1, ic + 1).isOccupied()) {
                    return true;
                }
            }
        }

        // king
        else {
            if (ic == 0 && ir == 7) {
                if (!aa.getSquare(ir - 1, ic + 1).isOccupied()) {
                    return true;
                }
            }
            else if (ic == 7 && ir == 0) {
                if (!aa.getSquare(ir + 1, ic - 1).isOccupied()) {
                    return true;
                }
            }
            else if (ic == 0) {
                if (!aa.getSquare(ir + 1, ic + 1).isOccupied() ||
                        !aa.getSquare(ir - 1, ic + 1).isOccupied()) {
                    return true;
                }
            }
            else if (ic == 7) {
                if (!aa.getSquare(ir + 1, ic - 1).isOccupied() ||
                        !aa.getSquare(ir - 1, ic - 1).isOccupied()) {
                    return true;
                }
            }
            else if (ir == 0) {
                if (!aa.getSquare(ir + 1, ic - 1).isOccupied() ||
                        !aa.getSquare(ir + 1, ic + 1).isOccupied()) {
                    return true;
                }
            }
            else if (ir == 7) {
                if (!aa.getSquare(ir - 1, ic - 1).isOccupied() ||
                        !aa.getSquare(ir - 1, ic + 1).isOccupied()) {
                    return true;
                }
            }
            else {
                if (!aa.getSquare(ir + 1, ic - 1).isOccupied() ||
                        !aa.getSquare(ir + 1, ic + 1).isOccupied()
                        || !aa.getSquare(ir - 1, ic - 1).isOccupied()
                        || !aa.getSquare(ir - 1, ic + 1).isOccupied()) {
                    return true;
                }
            }
        }
        return false;
    }

    // determines if the game is over by checking to see if there are any
    // possible moves a specified piece can make on the specified game board
    public boolean availableJump(Piece p, int ir, int ic, boolean color, Board aa) {
        // red stone
        if (color && !p.isKing()) {
            if (ir == 6 || ir == 7) {
                aa.update();
                return false;
            }
            else if (ic == 0 || ic == 1) {
                if (p.canItJump(ir, ic, ir + 2, ic + 2, color, aa)) {
                    return true;
                }
            }
            else if (ic == 7 || ic == 6) {
                if (p.canItJump(ir, ic, ir + 2, ic - 2, color, aa)) {
                    return true;
                }
            }
            else {
                if (p.canItJump(ir, ic, ir + 2, ic + 2, color, aa) ||
                        p.canItJump(ir, ic, ir + 2, ic - 2, color, aa)) {
                    return true;
                }
            }
        }

        // black stone
        else if (!color && !p.isKing()) {
            if (ir == 1 || ir == 0) {
                aa.update();
                return false;
            }
            else if (ic == 0 || ic == 1) {
                if (p.canItJump(ir, ic, ir - 2, ic + 2, color, aa)) {
                    return true;
                }
            }
            else if (ic == 7 || ic == 6) {
                if (p.canItJump(ir, ic, ir - 2, ic - 2, color, aa)) {
                    return true;
                }
            }
            else {
                if (p.canItJump(ir, ic, ir - 2, ic + 2, color, aa) ||
                        p.canItJump(ir, ic, ir - 2, ic - 2, color, aa)) {
                    return true;
                }
            }
        }

        // kings
        else {
            if ((ir == 0 && ic == 1) || (ir == 1 && ic == 0)) {
                if (p.canItJump(ir, ic, ir + 2, ic + 2, color, aa)) {
                    return true;
                }
            }
            else if ((ir == 0 && ic == 7) || (ir == 1 && ic == 6)) {
                if (p.canItJump(ir, ic, ir + 2, ic - 2, color, aa)) {
                    return true;
                }
            }
            else if ((ir == 6 && ic == 1) || (ir == 7 && ic == 0)) {
                if (p.canItJump(ir, ic, ir - 2, ic + 2, color, aa)) {
                    return true;
                }
            }
            else if ((ir == 6 && ic == 7) || (ir == 7 && ic == 6)) {
                if (p.canItJump(ir, ic, ir - 2, ic - 2, color, aa)) {
                    return true;
                }
            }
            else if ((ir == 0 && (ic == 3 || ic == 5))
                    || (ir == 1 && (ic == 2 || ic == 4))) {
                if (p.canItJump(ir, ic, ir + 2, ic - 2, color, aa)
                        || p.canItJump(ir, ic, ir + 2, ic + 2, color, aa)) {
                    return true;
                }
            }
            else if ((ic == 0 && (ir == 3 || ir == 5))
                    || (ic == 1 && (ir == 2 || ir == 4))) {
                if (p.canItJump(ir, ic, ir + 2, ic + 2, color, aa)
                        || p.canItJump(ir, ic, ir - 2, ic + 2, color, aa)) {
                    return true;
                }
            }
            else if ((ic == 6 && (ir == 3 || ir == 5))
                    || (ic == 7 && (ir == 2 || ir == 4))) {
                if (p.canItJump(ir, ic, ir + 2, ic - 2, color, aa)
                        || p.canItJump(ir, ic, ir - 2, ic - 2, color, aa)) {
                    return true;
                }
            }
            else if ((ir == 6 && (ic == 3 || ic == 5))
                    || (ir == 7 && (ic == 2 || ic == 4))) {
                if (p.canItJump(ir, ic, ir - 2, ic + 2, color, aa)
                        || p.canItJump(ir, ic, ir - 2, ic - 2, color, aa)) {
                    return true;
                }
            }
            else {
                if (p.canItJump(ir, ic, ir - 2, ic + 2, color, aa)
                        || p.canItJump(ir, ic, ir - 2, ic - 2, color, aa)
                        || p.canItJump(ir, ic, ir + 2, ic - 2, color, aa)
                        || p.canItJump(ir, ic, ir + 2, ic + 2, color, aa)) {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {

    }
}
