// The player class creates a new player which is useful for assigning turns,
// making sure that theyy aren't manipulating opponets pieces (or capturing
// their own), and declaring the game over
public class Player {
    // saves color of player
    private boolean isRed;
    // keeps track of captured pieces
    private int capturedPieces;
    // concedes
    private boolean givesUp;

    // Player Constructor takes in color
    public Player(boolean r) {
        isRed = r;
    }

    // returns color of player
    public boolean getColor() {
        return isRed;
    }

    // declares if game is over
    public void capture() {
        capturedPieces++;
    }

    public boolean hasConceded() {
        return givesUp;
    }

    public void conceded() {
        givesUp = true;
    }

    // determines if the game is over by checking to see if there are any
    // possible moves any piece can make on the specified game board
    public boolean gameOver() {
        if (capturedPieces == 12) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
