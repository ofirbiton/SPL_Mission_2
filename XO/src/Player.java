//Naim Moshe 315852269 & Ofir Biton 208582494
public abstract class Player implements Runnable{
    protected final Content contentType;
    protected final Game game;
    public Player(Content playerContent,Game game) {
        this.contentType = playerContent;
        this.game = game;
    }

    public abstract void run();

    //Make the next move
    public abstract void makeMove(Location[] freeLocations);

    //Check if there is 4 of sequence
    protected synchronized boolean checkIfWin(Content player){
        return checkRows(player) || checkCols(player)|| checkMainDiagonals(player) || checkAntiDiagonals(player);
    }

    private boolean checkBoardContent(Content player, int startRow, int startCol, int rowIncrement, int colIncrement) {
        for (int i = 0; i < 4; i++) {
            int row = startRow + i * rowIncrement;
            int col = startCol + i * colIncrement;

            if (game.getGameBoard()[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonals(Content player) {
        // Check upper anti-diagonal
        if (checkBoardContent(player, 0, 3, 1, -1)) {
            return true;
        }

        // Check anti-diagonal
        for (int i = 0; i < 2; i++) {
            if (checkBoardContent(player, game.getSize() - 1 - i,i, -1, 1)) {
                return true;
            }
        }

        // Check under anti-diagonal
        return checkBoardContent(player,  1, game.getSize() - 1, 1, -1);
    }

    private boolean checkMainDiagonals(Content player) {
        // Check upper main diagonal
        if (checkBoardContent(player, 0, 1, 1, 1)) {
            return true;
        }

        // Check main diagonal
        for (int i = 0; i < 2; i++) {
            if (checkBoardContent(player, i, i, 1, 1)) {
                return true;
            }
        }

        // Check under main diagonal
        return checkBoardContent(player, 1, 0, 1, 1);
    }

    private boolean checkCols(Content player) {
        for (int i = 0; i < game.getGameBoard().length; i++) {
            for (int j = 0; j < 2; j++) {
                if (checkBoardContent(player, j, i, 1, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkRows(Content player) {
        for (int i = 0; i < game.getGameBoard().length; i++) {
            for (int j = 0; j < 2; j++) {
                if (checkBoardContent(player, i, j, 0, 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
