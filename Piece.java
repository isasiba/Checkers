public abstract class Piece {
    private boolean isred;
    private boolean captured;

    public Piece(boolean color) {
        isred = color;
        captured = false;
    }

    public boolean getColor() {
        return isred;
    }

    public boolean isCaptured() {
        return captured;
    }

    public void capture() {
        captured = true;
    }

    public String toString() {
        if (isred) {
            return "red piece";
        }
        else {
            return "black piece";
        }
    }

    public boolean upRight(int ir, int ic, int er, int ec) {
        if (er > ir && ec > ic) {
            return true;
        }
        return false;
    }

    public boolean upLeft(int ir, int ic, int er, int ec) {
        if (er > ir && ic > ec) {
            return true;
        }
        return false;
    }

    public boolean downLeft(int ir, int ic, int er, int ec) {
        if (er < ir && ec < ic) {
            return true;
        }
        return false;
    }

    public boolean downRight(int ir, int ic, int er, int ec) {
        if (er < ir && ec > ic) {
            return true;
        }
        return false;
    }

    public abstract void move(int ir, int ic, int er, int ec, boolean r, Board a);

    public abstract double getXvalue();

    public abstract double getYvalue();

    public abstract boolean canItJump(int ir, int ic, int er, int ec, boolean r, Board a);

    public abstract boolean id(int ir, int ic, int er, int ec, boolean r);

    public abstract boolean isKing();

    public abstract void jump(int a, int b, int c, int d, boolean r, Board p);

    public static void main(String[] args) {

    }
}
