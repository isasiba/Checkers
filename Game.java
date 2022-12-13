public class Game {
    // private final Object keyLock = new Object();
    // private LinkedList<Character> keysTyped = new LinkedList<Character>();
    //
    // public void keyTyped(KeyEvent e) {
    //     synchronized (keyLock) {
    //         char c = Character.toLowerCase(e.getKeyChar());
    //         keysTyped.addFirst(c);
    //     }
    //
    //     public char nextKeyPlayed() {
    //         synchronized (keyLock) {
    //             if (keysTyped.isEmpty()) {
    //                 throw new NoSuchElementException(
    //                         "your program has already processed all typed keys");
    //             }
    //             return keysTyped.removeLast();
    //         }
    //     }
    //
    //     public boolean hasNextKeyPlayed() {
    //         synchronized (keyLock) {
    //             return !keysTyped.isEmpty();
    //         }
    //     }


    public static void main(String[] args) {
        Board gameboard = new Board();
        StdOut.println("Welcome to Checkers!");
        StdOut.println("Player 1, type your name.");
        String p1 = StdIn.readString();
        Player player1 = new Player(p1, true);
        StdOut.println(p1 + ", you will be red.");
        StdOut.println("Player 2, type your name.");
        String p2 = StdIn.readString();
        Player player2 = new Player(p2, false);
        StdOut.println(p2 + ", you will be black.");
        StdOut.println("Press the A key to begin.");
        // for (int i = 0; i < 64; i++) {
        //     String oldplace = StdIn.readString();
        //     int oldColumn = oldplace.charAt(0) - 'a';
        //     int oldRow = Integer.parseInt(oldplace.substring(1, 2)) - 1;
        //     StdOut.println(gameboard.toString(oldRow, oldColumn));
        //
        // }
        boolean go = true;
        while (go) {
            StdOut.print(
                    p1 + ", what square is the piece you want to move CURRENTLY on? ");
            StdOut.println(
                    "Please remember to use the associated number and letter of the square (e.g. e1)");
            String oldplace = StdIn.readString();
            int oldColumn = oldplace.charAt(0) - 'a';
            int oldRow = Integer.parseInt(oldplace.substring(1, 2)) - 1;
            boolean validMove = gameboard.canItMoveThere(oldRow, oldColumn);
            while (!validMove) {
                System.out.println("Not a valid square. Please try again.");
                String plea = StdIn.readString();
                oldColumn = plea.charAt(0) - 'a';
                oldRow = Integer.parseInt(plea.substring(1, 2)) - 1;
                validMove = gameboard.canItMoveThere(oldRow, oldColumn);
            }
            Piece current = gameboard.getSquare(oldRow, oldColumn).getPiece();
            System.out.println(
                    p1 + ", what square would you like to move your piece to?");
            StdOut.println("Move");
            String newplace = StdIn.readString();
            int newColumn = newplace.charAt(0) - 'a';
            int newRow = Integer.parseInt(newplace.substring(1, 2)) - 1;
            boolean e = current.canItMoveThere(oldRow, oldColumn, newRow, newColumn,
                                               current.getColor(),
                                               gameboard);
            boolean f = current.canItJump(oldRow, oldColumn, newRow, newColumn,
                                          current.getColor(),
                                          gameboard);
            while (!e && !f) {
                System.out.println("Not a valid move. Try again.");
                String ple = StdIn.readString();
                newColumn = ple.charAt(0) - 'a';
                newRow = Integer.parseInt(ple.substring(1, 2)) - 1;
                e = current.canItMoveThere(oldRow, oldColumn, newRow, newColumn, current.getColor(),
                                           gameboard);
            }
            if (f) {
                current.jump(oldRow, oldColumn, newRow, newColumn, current.getColor(), gameboard);
            }
            else if (e) {
                current.move(oldRow, oldColumn, newRow, newColumn, current.getColor(), gameboard);
            }
            gameboard.drawBoard();
            gameboard.drawPieces();
            if (player1.gameOverStones(gameboard)) {
                break;
            }
            // fix it to where player 2 can only move black
            StdOut.print(
                    p2 + ", what square is the piece you want to move CURRENTLY on? ");
            StdOut.println(
                    "Please remember to use the associated number and letter of the square (e.g. e1)");
            String op = StdIn.readString();
            int oldColumn2 = op.charAt(0) - 'a';
            int oldRow2 = Integer.parseInt(op.substring(1, 2)) - 1;
            boolean vm = gameboard.canItMoveThere(oldRow2, oldColumn2);
            while (!vm) {
                System.out.println("Not a valid square. Please try again.");
                String plea = StdIn.readString();
                oldColumn2 = plea.charAt(0) - 'a';
                oldRow2 = Integer.parseInt(plea.substring(1, 2)) - 1;
                vm = gameboard.canItMoveThere(oldRow2, oldColumn2);
            }
            Piece current2 = gameboard.getSquare(oldRow2, oldColumn2).getPiece();
            System.out.println(
                    p2 + ", what square would you like to move your piece to?");
            StdOut.println("Move");
            String np = StdIn.readString();
            int newColumn2 = np.charAt(0) - 'a';
            int newRow2 = Integer.parseInt(np.substring(1, 2)) - 1;
            boolean ee = current.canItMoveThere(oldRow2, oldColumn2, newRow2, newColumn2,
                                                current2.getColor(),
                                                gameboard);
            while (!ee) {
                System.out.println("Not a valid move. Try again.");
                String ple = StdIn.readString();
                newColumn2 = ple.charAt(0) - 'a';
                newRow2 = Integer.parseInt(ple.substring(1, 2)) - 1;
                ee = current2.canItMoveThere(oldRow2, oldColumn2, newRow2, newColumn2,
                                             current2.getColor(),
                                             gameboard);
            }
            current2.move(oldRow2, oldColumn2, newRow2, newColumn2, current2.getColor(), gameboard);
            gameboard.drawBoard();
            gameboard.drawPieces();
            // include if king game over
            if (player2.gameOverStones(gameboard)) {
                break;
            }
            StdOut.println("That's the end of this round!");
            StdOut.println(gameboard.getSquare(3, 6).isOccupied());
        }
        StdOut.println("Game Over");
        StdOut.println("GAME OVER!");
        if (player1.gameOverStones(gameboard)) {
            StdOut.println("Congratulations " + p1 + " on your win.");
        }
        else {
            StdOut.println("Congratulations " + p2 + " on your win.");
        }
        StdOut.println("Thanks for playing! See you again later!");
    }


    // boolean f = current.canItJump(oldRow, oldColumn, newRow, newColumn, current.getColor(),
    // gameboard);
    // StdOut.println(f);


}
