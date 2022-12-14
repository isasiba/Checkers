import java.awt.Color;

public class Board {
    private Square[][] mainboard;

    public Board() {
        mainboard = new Square[8][8];
        mainboard[0][0] = new Square(true, 1, 1);
        mainboard[0][1] = new Square(new Stones(true, 3, 1), false, 3, 1);
        mainboard[0][2] = new Square(true, 5, 1);
        mainboard[0][3] = new Square(new Stones(true, 7, 1), false, 7, 1);
        mainboard[0][4] = new Square(true, 9, 1);
        mainboard[0][5] = new Square(new Stones(true, 11, 1), false, 11, 1);
        mainboard[0][6] = new Square(true, 13, 1);
        mainboard[0][7] = new Square(new Stones(true, 15, 1), false, 15, 1);
        mainboard[1][0] = new Square(new Stones(true, 1, 3), false, 1, 3);
        mainboard[1][1] = new Square(true, 3, 3);
        mainboard[1][2] = new Square(new Stones(true, 5, 3), false, 5, 3);
        mainboard[1][3] = new Square(true, 7, 3);
        mainboard[1][4] = new Square(new Stones(true, 9, 3), false, 9, 3);
        mainboard[1][5] = new Square(true, 11, 3);
        mainboard[1][6] = new Square(new Stones(true, 13, 3), false, 13, 3);
        mainboard[1][7] = new Square(true, 15, 3);
        mainboard[2][0] = new Square(true, 1, 5);
        mainboard[2][1] = new Square(new Stones(true, 3, 5), false, 3, 5);
        mainboard[2][2] = new Square(true, 5, 5);
        mainboard[2][3] = new Square(new Stones(true, 7, 5), false, 7, 5);
        mainboard[2][4] = new Square(true, 9, 5);
        mainboard[2][5] = new Square(new Stones(true, 11, 5), false, 11, 5);
        mainboard[2][6] = new Square(true, 13, 5);
        mainboard[2][7] = new Square(new Stones(true, 15, 5), false, 15, 5);
        mainboard[3][0] = new Square(false, 1, 7);
        mainboard[3][1] = new Square(true, 3, 7);
        mainboard[3][2] = new Square(false, 5, 7);
        mainboard[3][3] = new Square(true, 7, 7);
        mainboard[3][4] = new Square(false, 9, 7);
        mainboard[3][5] = new Square(true, 11, 7);
        mainboard[3][6] = new Square(false, 13, 7);
        mainboard[3][7] = new Square(true, 15, 7);
        mainboard[4][0] = new Square(true, 1, 9);
        mainboard[4][1] = new Square(false, 3, 9);
        mainboard[4][2] = new Square(true, 5, 9);
        mainboard[4][3] = new Square(false, 7, 9);
        mainboard[4][4] = new Square(true, 9, 9);
        mainboard[4][5] = new Square(false, 11, 9);
        mainboard[4][6] = new Square(true, 13, 9);
        mainboard[4][7] = new Square(false, 15, 9);
        mainboard[5][0] = new Square(new Stones(false, 1, 11), false, 1, 11);
        mainboard[5][1] = new Square(true, 3, 11);
        mainboard[5][2] = new Square(new Stones(false, 5, 11), false, 5, 11);
        mainboard[5][3] = new Square(true, 7, 11);
        mainboard[5][4] = new Square(new Stones(false, 9, 11), false, 9, 11);
        mainboard[5][5] = new Square(true, 11, 11);
        mainboard[5][6] = new Square(new Stones(false, 13, 11), false, 13, 11);
        mainboard[5][7] = new Square(true, 15, 11);
        mainboard[6][0] = new Square(true, 1, 13);
        mainboard[6][1] = new Square(new Stones(false, 3, 13), false, 3, 13);
        mainboard[6][2] = new Square(true, 5, 13);
        mainboard[6][3] = new Square(new Stones(false, 7, 13), false, 7, 13);
        mainboard[6][4] = new Square(true, 9, 13);
        mainboard[6][5] = new Square(new Stones(false, 11, 13), false, 11, 13);
        mainboard[6][6] = new Square(true, 13, 13);
        mainboard[6][7] = new Square(new Stones(false, 15, 13), false, 15, 13);
        mainboard[7][0] = new Square(new Stones(false, 1, 15), false, 1, 15);
        mainboard[7][1] = new Square(true, 3, 15);
        mainboard[7][2] = new Square(new Stones(false, 5, 15), false, 5, 15);
        mainboard[7][3] = new Square(true, 7, 15);
        mainboard[7][4] = new Square(new Stones(false, 9, 15), false, 9, 15);
        mainboard[7][5] = new Square(true, 11, 15);
        mainboard[7][6] = new Square(new Stones(false, 13, 15), false, 13, 15);
        mainboard[7][7] = new Square(true, 15, 15);

    }

    public Square getSquare(int row, int col) {
        return mainboard[row][col];
    }

    public void drawPieces() {
        StdDraw.setScale(0.0, 16.0);
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (mainboard[row][col].isOccupied()) {
                    Piece p = mainboard[row][col].getPiece();
                    if (p.getColor() && !p.isKing()) {
                        StdDraw.picture(p.getXvalue(), p.getYvalue(), "RedStone.jpg", 1, 1);
                    }
                    else if (!p.getColor() && !p.isKing()) {
                        StdDraw.picture(p.getXvalue(), p.getYvalue(), "BlackStone.jpg", 1, 1);
                    }
                    else if (p.getColor() && p.isKing()) {
                        StdDraw.picture(p.getXvalue(), p.getYvalue(), "RedKing.jpg", 1, 1);
                    }
                    else {
                        StdDraw.picture(p.getXvalue(), p.getYvalue(), "BlackKing.jpg", 1, 1);
                    }
                }
            }
        }
    }

    public void drawBoard() {
        StdDraw.setScale(0.0, 16.0);
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((row % 2 == 0 && col % 2 == 0) || (row % 2 == 1 && col % 2 == 1)) {
                    StdDraw.setPenColor(Color.RED);
                    StdDraw.filledSquare(row * 2 + 1, col * 2 + 1, 1);
                }
                else {
                    StdDraw.setPenColor(Color.BLACK);
                    StdDraw.filledSquare(row * 2 + 1, col * 2 + 1, 1);
                }
            }
        }
    }

    public boolean canItMoveThereIntially(String s, Player p) {
        if (s.length() != 2) {
            return false;
        }
        int iy = s.charAt(0) - 'a';
        int ix = Integer.parseInt(s.substring(1, 2)) - 1;

        if ((ix > 7 || ix < 0) || (iy > 7 || iy < 0)) {
            return false;
        }
        boolean isPiece = this.getSquare(ix, iy).isOccupied();
        if (!isPiece) {
            return false;
        }
        if (this.getPieceOnSquare(ix, iy).getColor() != p.getColor()) {
            return false;
        }
        return true;
    }

    public boolean canItMoveThereAfter(String s) {
        if (s.length() != 2) {
            return false;
        }
        int iy = s.charAt(0) - 'a';
        int ix = Integer.parseInt(s.substring(1, 2)) - 1;

        if ((ix > 7 || ix < 0) || (iy > 7 || iy < 0)) {
            return false;
        }

        if (this.getSquare(ix, iy).getColor()) {
            return false;
        }
        boolean isPiece = this.getSquare(ix, iy).isOccupied();
        if (isPiece) {
            return false;
        }
        
        return true;
    }

    public Piece getPieceOnSquare(int x, int y) {
        return mainboard[x][y].getPiece();
    }

    public String toString(int ir, int ic) {
        if (this.getSquare(ir, ic).isOccupied()) {
            return this.getPieceOnSquare(ir, ic).toString();
        }
        return "null";
    }

    public static void update(Board a) {
        if (!a.getSquare(0, 1).getPiece().getColor() && a.getSquare(0, 1).isOccupied()) {
            a.getSquare(0, 1).leave();
            King temp = new King(false, 3, 1);
            a.getSquare(0, 1).setPiece(temp);
        }
        else if (!a.getSquare(0, 3).getPiece().getColor() && a.getSquare(0, 3).isOccupied()) {
            a.getSquare(0, 3).leave();
            King temp = new King(false, 7, 1);
            a.getSquare(0, 3).setPiece(temp);
        }
        else if (!a.getSquare(0, 5).getPiece().getColor() && a.getSquare(0, 5).isOccupied()) {
            a.getSquare(0, 5).leave();
            King temp = new King(false, 11, 1);
            a.getSquare(0, 5).setPiece(temp);
        }
        else if (!a.getSquare(0, 7).getPiece().getColor() && a.getSquare(0, 7).isOccupied()) {
            a.getSquare(0, 7).leave();
            King temp = new King(false, 15, 1);
            a.getSquare(0, 7).setPiece(temp);
        }
        else if (a.getSquare(7, 0).getPiece().getColor() && a.getSquare(7, 0).isOccupied()) {
            a.getSquare(7, 0).leave();
            King temp = new King(true, 1, 15);
            a.getSquare(7, 0).setPiece(temp);
        }
        else if (a.getSquare(7, 2).getPiece().getColor() && a.getSquare(7, 0).isOccupied()) {
            a.getSquare(7, 2).leave();
            King temp = new King(true, 5, 15);
            a.getSquare(7, 2).setPiece(temp);
        }
        else if (a.getSquare(7, 4).getPiece().getColor() && a.getSquare(7, 0).isOccupied()) {
            a.getSquare(7, 4).leave();
            King temp = new King(true, 9, 15);
            a.getSquare(7, 4).setPiece(temp);
        }
        else if (a.getSquare(7, 6).getPiece().getColor() && a.getSquare(7, 0).isOccupied()) {
            a.getSquare(7, 6).leave();
            King temp = new King(true, 13, 15);
            a.getSquare(7, 6).setPiece(temp);
        }
    }


    public static void main(String[] args) {
        Board a = new Board();
        a.drawBoard();
        a.drawPieces();
    }
}
