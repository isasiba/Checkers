// The Game class is where the actual game is played. It's the class
// that ties all of the other classes together to create the fun game
// of checkers!
public class Game {


    public static void main(String[] args) {

        //*INTRODUCTION*//
        Board gameboard = new Board();
        StdOut.println("Welcome to Checkers!");
        StdOut.println("You will move your piece using square notation. "
                               + "Columns are lettered A-H with A in the bottom left corner. "
                               + "Rows are lettered 1-8 with 1 in the bottom left corner. " +
                               "For example, the square A1 is in the bottom left, and H8 in the top right.");
        StdOut.println("Player 1, type your name.");
        String p1 = StdIn.readString();
        Player player1 = new Player(true);
        StdOut.println(p1 + ", you will be red.");
        StdOut.println("Player 2, type your name.");
        String p2 = StdIn.readString();
        Player player2 = new Player(false);
        StdOut.println(p2 + ", you will be black.");
        gameboard.drawBoard();
        gameboard.drawPieces();

        // MAIN LOOP; GOES THROUGH ONE LOOP FOR EACH PLAYER //
        boolean go = true;
        while (go) {


            // PLAYER 1 TURN//
            StdOut.print(
                    p1 + ", what square is the piece you want to move CURRENTLY on? ");
            StdOut.println(
                    "Please remember to use the associated number and letter of the square (e.g. e1)");
            String oldplace = StdIn.readString();

            // checks to make sure its a valid square
            boolean validMove = gameboard.canItMoveThereIntially(oldplace, player1);
            while (!validMove) {
                System.out.println("Not a valid square. Please try again.");
                String plea = StdIn.readString();
                oldplace = plea;
                validMove = gameboard.canItMoveThereIntially(plea, player1);
            }
            int oldColumn = oldplace.charAt(0) - 'a';
            int oldRow = Integer.parseInt(oldplace.substring(1, 2)) - 1;

            // gets piece on square (piece that will be moved)
            Piece current = gameboard.getSquare(oldRow, oldColumn).getPiece();
            System.out.println(
                    p1 + ", what square would you like to move your piece to?");
            String newplace = StdIn.readString();

            // checks to make sure destination is a valid square
            boolean valid = gameboard.canItMoveThereAfter(newplace);
            while (!valid) {
                System.out.println("Not a valid square. Please try again.");
                String plea = StdIn.readString();
                newplace = plea;
                valid = gameboard.canItMoveThereAfter(plea);
            }
            int newColumn = newplace.charAt(0) - 'a';
            int newRow = Integer.parseInt(newplace.substring(1, 2)) - 1;

            // once destination is valid, checks if it can move there via regular movements
            boolean e = current.id(oldRow, oldColumn, newRow, newColumn,
                                   current.getColor());
            // checks if it can move to destination via jumping
            boolean f = current.canItJump(oldRow, oldColumn, newRow, newColumn,
                                          current.getColor(),
                                          gameboard);

            // if it can't move somewhere via moves or jumping, coaxes player to change input
            while (!e && !f) {
                System.out.println("Not a valid move. Pick a new destination.");
                String ple = StdIn.readString();
                boolean v = gameboard.canItMoveThereAfter(ple);
                while (!v) {
                    System.out.println("Not a valid square. Please try again.");
                    String plea = StdIn.readString();
                    ple = plea;
                    v = gameboard.canItMoveThereAfter(plea);
                }
                newColumn = ple.charAt(0) - 'a';
                newRow = Integer.parseInt(ple.substring(1, 2)) - 1;
                e = current.id(oldRow, oldColumn, newRow, newColumn, current.getColor());
                f = current.canItJump(oldRow, oldColumn, newRow, newColumn,
                                      current.getColor(),
                                      gameboard);
            }

            // if the piece can jump, asks if they want to jump again
            if (f) {
                current.jump(oldRow, oldColumn, newRow, newColumn, gameboard);
                gameboard.update();
                gameboard.drawBoard();
                gameboard.drawPieces();
                String answer = "y";
                boolean stay = true;
                while (answer.equals("y") && stay) {
                    StdOut.println(
                            "If there's a possible jump, you can move again. Would you like to do so? "
                                    + "Press y for yes, n for no.");
                    answer = StdIn.readString().toLowerCase();
                    if (answer.equals("y")) {
                        System.out.println(
                                p1 + ", what square would you like to move your piece to?");
                        String newDestination = StdIn.readString();

                        // checks to make sure destination is a valid square
                        boolean v = gameboard.canItMoveThereAfter(newDestination);
                        while (!v) {
                            System.out.println("Not a valid square. Please try again.");
                            String plea = StdIn.readString();
                            newDestination = plea;
                            v = gameboard.canItMoveThereAfter(plea);
                        }
                        int newC = newDestination.charAt(0) - 'a';
                        int newR = Integer.parseInt(newDestination.substring(1, 2)) - 1;

                        // make sure that its a valid jump
                        boolean isValidJump = current.canItJump(newRow, newColumn, newR, newC,
                                                                current.getColor(),
                                                                gameboard);
                        if (isValidJump) {
                            current.jump(newRow, newColumn, newR, newC,
                                         gameboard);
                        }
                        while (!isValidJump) {
                            StdOut.println("Not a valid move. Pick a new destination. "
                                                   + "Or type q to end your turn.");
                            String pl = StdIn.readString();
                            if (pl.toLowerCase().equals("q")) {
                                stay = false;
                                break;
                            }
                            boolean canIt = gameboard.canItMoveThereAfter(pl);
                            while (!canIt) {
                                System.out.println("Not a valid square. Please try again.");
                                String plea = StdIn.readString();
                                pl = plea;
                                canIt = gameboard.canItMoveThereAfter(plea);
                            }
                            newColumn = pl.charAt(0) - 'a';
                            newRow = Integer.parseInt(pl.substring(1, 2)) - 1;
                            isValidJump = current.canItJump(oldRow, oldColumn, newRow, newColumn,
                                                            current.getColor(),
                                                            gameboard);
                        }
                        newRow = newR;
                        newColumn = newC;
                        gameboard.update();
                        gameboard.drawBoard();
                        gameboard.drawPieces();
                    }
                }
            }
            // if the piece can't jump, moves regularly
            else if (e) {
                current.move(oldRow, oldColumn, newRow, newColumn, current.getColor(), gameboard);
            }

            // updates drawing
            gameboard.update();
            gameboard.drawBoard();
            gameboard.drawPieces();


            // checks to make sure game isn't over
            if (!player1.gameOverStones(gameboard)) {
                break;
            }

            // PLAYER 2 TURN//
            StdOut.print(
                    p2 + ", what square is the piece you want to move CURRENTLY on? ");
            StdOut.println(
                    "Please remember to use the associated number and letter of the square (e.g. e1)");
            String op = StdIn.readString();

            // checks to make sure its a valid square
            boolean vm = gameboard.canItMoveThereIntially(op, player2);
            while (!vm) {
                System.out.println("Not a valid square. Please try again.");
                String plea = StdIn.readString();
                op = plea;
                vm = gameboard.canItMoveThereIntially(plea, player2);
            }
            int oldColumn2 = op.charAt(0) - 'a';
            int oldRow2 = Integer.parseInt(op.substring(1, 2)) - 1;

            // gets piece on square (piece that will be moved)
            Piece current2 = gameboard.getSquare(oldRow2, oldColumn2).getPiece();
            System.out.println(
                    p2 + ", what square would you like to move your piece to?");
            String np = StdIn.readString();

            // checks to make sure destination is a valid square
            boolean validty = gameboard.canItMoveThereAfter(np);
            while (!validty) {
                System.out.println("Not a valid square. Please try again.");
                String plea = StdIn.readString();
                np = plea;
                validty = gameboard.canItMoveThereAfter(plea);
            }
            int newColumn2 = np.charAt(0) - 'a';
            int newRow2 = Integer.parseInt(np.substring(1, 2)) - 1;

            // once destination is valid, checks if it can move there via regular movements
            boolean ee = current2.id(oldRow2, oldColumn2, newRow2, newColumn2,
                                     current2.getColor());
            // checks if it can move to destination via jumping
            boolean ff = current2.canItJump(oldRow2, oldColumn2, newRow2, newColumn2,
                                            current2.getColor(),
                                            gameboard);

            // if it can't move somewhere via moves or jumping, coaxes player to change input
            while (!ee && !ff) {
                System.out.println("Not a valid move. Pick a new destination.");
                String ple = StdIn.readString();
                boolean v = gameboard.canItMoveThereAfter(ple);
                while (!v) {
                    System.out.println("Not a valid square. Please try again.");
                    String plea = StdIn.readString();
                    ple = plea;
                    v = gameboard.canItMoveThereAfter(plea);
                }
                newColumn2 = ple.charAt(0) - 'a';
                newRow2 = Integer.parseInt(ple.substring(1, 2)) - 1;
                ee = current2.id(oldRow2, oldColumn2, newRow2, newColumn2,
                                 current2.getColor());
                ff = current2.canItJump(oldRow2, oldColumn2, newRow2, newColumn2,
                                        current2.getColor(),
                                        gameboard);
            }

            // if the piece can jump, forces it to jump
            if (ff) {
                current2.jump(oldRow2, oldColumn2, newRow2, newColumn2,
                              gameboard);
                gameboard.update();
                gameboard.drawBoard();
                gameboard.drawPieces();
                String answer2 = "y";
                boolean stay2 = true;
                while (answer2.equals("y") && stay2) {
                    StdOut.println(
                            "If there's a possible jump, you can move again. Would you like to do so? "
                                    + "Press y for yes, n for no.");
                    answer2 = StdIn.readString().toLowerCase();
                    if (answer2.equals("y")) {
                        System.out.println(
                                p2 + ", what square would you like to move your piece to?");
                        String newDestination2 = StdIn.readString();

                        // checks to make sure destination is a valid square
                        boolean v2 = gameboard.canItMoveThereAfter(newDestination2);
                        while (!v2) {
                            System.out.println("Not a valid square. Please try again.");
                            String plea = StdIn.readString();
                            newDestination2 = plea;
                            v2 = gameboard.canItMoveThereAfter(plea);
                        }
                        int newC2 = newDestination2.charAt(0) - 'a';
                        int newR2 = Integer.parseInt(newDestination2.substring(1, 2)) - 1;

                        // make sure that its a valid jump
                        boolean isValidJump2 = current2.canItJump(newRow2, newColumn2, newR2, newC2,
                                                                  current2.getColor(),
                                                                  gameboard);
                        if (isValidJump2) {
                            current2.jump(newRow2, newColumn2, newR2, newC2,
                                          gameboard);
                        }
                        while (!isValidJump2) {
                            StdOut.println(
                                    "Not a valid move. Pick a new destination. Or type q to end move.");
                            String pl2 = StdIn.readString();
                            if (pl2.toLowerCase().equals("q")) {
                                stay2 = false;
                                break;
                            }
                            boolean canIt2 = gameboard.canItMoveThereAfter(pl2);
                            while (!canIt2) {
                                System.out.println("Not a valid square. Please try again.");
                                String plea2 = StdIn.readString();
                                pl2 = plea2;
                                canIt2 = gameboard.canItMoveThereAfter(plea2);
                            }
                            newColumn2 = pl2.charAt(0) - 'a';
                            newRow2 = Integer.parseInt(pl2.substring(1, 2)) - 1;
                            isValidJump2 = current2.canItJump(oldRow2, oldColumn2, newRow2,
                                                              newColumn2,
                                                              current2.getColor(),
                                                              gameboard);
                        }
                        newRow2 = newR2;
                        newColumn2 = newC2;
                        gameboard.update();
                        gameboard.drawBoard();
                        gameboard.drawPieces();
                    }
                }
            }

            // if the piece can't jump, moves regularly
            else if (ee) {
                current2.move(oldRow2, oldColumn2, newRow2, newColumn2, current2.getColor(),
                              gameboard);
            }

            // updates drawing
            gameboard.update();
            gameboard.drawBoard();
            gameboard.drawPieces();

            // checks to make sure game isn't over
            if (!player2.gameOverStones(gameboard)) {
                break;
            }

            StdOut.println("That's the end of this round!");
        }
        StdOut.println("GAME OVER!");
        if (player1.gameOverStones(gameboard)) {
            StdOut.println("Congratulations " + p1 + " on your win.");
        }
        else {
            StdOut.println("Congratulations " + p2 + " on your win.");
        }
        StdOut.println("Thanks for playing! See you again later!");

    }
}




