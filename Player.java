// The player class creates a new player which is useful for assigning turns,
// making sure that theyy aren't manipulating opponets pieces (or capturing
// their own), and declaring the game over
public class Player {
    // saves color of player
    private boolean isRed;
    // keeps track of captured pieces
    private int capturedPieces;

    // Player Constructor takes in color
    public Player(boolean r) {
        isRed = r;
    }

    // returns color of player
    public boolean getColor() {
        return isRed;
    }

    // declares if game is over

    // determines if the game is over by checking to see if there are any
    // possible moves any piece can make on the specified game board
    public boolean gameOver(Board a) {
        boolean go = false;
        for (int i = 0; i < 8; i++) { // rows
            for (int j = 0; j < 8; j++) { // columns
                Square s = a.getSquare(i, j);
                if (!s.getColor() && s.isOccupied()) {
                    if (s.getPiece().getColor() == this.getColor()) {
                        Piece temp = s.getPiece();
                        if (s.availableMove(temp, i, j, temp.getColor(), a)
                                || s.availableJump(temp, i, j, temp.getColor(), a)) {
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
