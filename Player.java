public class Player {

    private String n;
    private boolean isRed;

    public Player(String name, boolean r) {
        n = name;
        isRed = r;
    }

    public boolean getColor() {
        return isRed;
    }


    public boolean gameOverStones(Board a) {
        // if (capturedPieces == 12) {
        //     return true;
        // }
        boolean go = true;
        for (int i = 0; i < 8; i++) { // rows
            for (int j = 0; j < 8; j++) { // columns
                if (!a.getSquare(i, j).getColor() && a.getSquare(i, j).isOccupied()) {
                    Piece temp = a.getPieceOnSquare(i, j);
                    boolean r = temp.getColor();
                    int x = i;
                    int y = j;
                    if (r) {
                        if (x - 1 > 0 && x + 1 < 8 && y + 1 < 8) {
                            if (temp.canItMoveThere(i, j, i + 1, j + 1, r, a)) {
                                go = false;
                            }
                            if (temp.canItMoveThere(i, j, i - 1, j + 1, r, a)) {
                                go = false;
                            }
                        }
                    }
                    else {
                        if (x - 1 > 0 && x + 1 < 8 && y - 1 > 0) {
                            if (temp.canItMoveThere(i, j, i + 1, j - 1, r, a)) {
                                go = false;
                            }
                            if (temp.canItMoveThere(i, j, i - 1, j - 1, r, a)) {
                                go = false;
                            }
                        }
                    }
                }
            }
        }
        return go;
    }

    public static void main(String[] args) {

    }
}
