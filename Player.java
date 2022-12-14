public class Player {
    // saves color of player
    private boolean isRed;

    // Player Constructor
    public Player(boolean r) {
        isRed = r;
    }

    // returns color of player
    public boolean getColor() {
        return isRed;
    }

    // determines if the game is over by checking to see if there are any
    // possible moves any piece can make
    public boolean gameOverStones(Board a) {
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
                            if (temp.id(i, j, i + 1, j + 1, r)) {
                                go = false;
                            }
                            if (temp.id(i, j, i - 1, j + 1, r)) {
                                go = false;
                            }
                        }
                    }
                    else {
                        if (x - 1 > 0 && x + 1 < 8 && y - 1 > 0) {
                            if (temp.id(i, j, i + 1, j - 1, r)) {
                                go = false;
                            }
                            if (temp.id(i, j, i - 1, j - 1, r)) {
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
