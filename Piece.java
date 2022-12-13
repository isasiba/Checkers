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


    public abstract void move(int ir, int ic, int er, int ec, boolean r, Board a);

    public abstract boolean canItMoveThere(int ir, int ic, int er, int ec, boolean r, Board a);

    public abstract double getXvalue();

    public abstract double getYvalue();

    public abstract boolean canItJump(int ir, int ic, int er, int ec, boolean r, Board a);

    public abstract boolean id(int ir, int ic, int er, int ec, boolean r);

    public abstract boolean isKing();

    public abstract void jump(int a, int b, int c, int d, boolean r, Board p);

    public static void main(String[] args) {

    }
}
