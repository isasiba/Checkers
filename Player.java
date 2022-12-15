// The player class creates a new player which is useful for assigning turns,
// making sure that theyy aren't manipulating opponets pieces (or capturing
// their own), and declaring the game over
public class Player {
    // saves color of player
    private boolean isRed;

    // Player Constructor takes in color
    public Player(boolean r) {
        isRed = r;
    }

    // returns color of player
    public boolean getColor() {
        return isRed;
    }

    // determines if the game is over by checking to see if there are any
    // possible moves any piece can make on the specified game board
    public boolean gameOverStones(Board a) {
        boolean go = false;
        boolean r = this.getColor();
        for (int i = 0; i < 8; i++) { // rows
            for (int j = 0; j < 8; j++) { // columns
                if (!a.getSquare(i, j).getColor() && a.getSquare(i, j).isOccupied()) {
                    if (a.getPieceOnSquare(i, j).getColor() == this.getColor()) {
                        Piece temp = a.getPieceOnSquare(i, j);
                        if (temp.availableMove(i, j, r, a)
                                || temp.availableJump(i, j, r, a)) {
                            go = true;
                            break;
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
