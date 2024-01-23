//Naim Moshe 315852269 & Ofir Biton 208582494
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Game {
    private final Content[][] gameBoard;
    private final int size = 5;
    private Content currentPlayer;
    protected Player player1;
    protected Player player2;
    private boolean stop;


    public Game() {
        gameBoard = new Content[size][size];
        initializeBoard();
        stop = false;
    }

    public synchronized void setCurrentPlayer(Content currentPlayer){
        this.currentPlayer = currentPlayer;
    }

    public synchronized Player getPlayer1(){
        return player1;
    }
    public synchronized Player getPlayer2(){
        return player2;
    }

    public synchronized void printBoard() {
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    public synchronized int getSize() {
        return size;
    }

    public synchronized Content[][] getGameBoard() {
        return gameBoard;
    }

    public synchronized void stop() {
        stop = true;
    }

    public synchronized boolean getStop() {
        return stop;
    }

    public synchronized Content getTurn(){
        return currentPlayer;
    }

    public synchronized Location[] getFreeCells() {
        ArrayList<Location> freeCells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (gameBoard[i][j] == Content.E) {
                    freeCells.add(new Location(i, j));
                }
            }
        }
        return freeCells.toArray(new Location[0]);
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            Arrays.fill(gameBoard[i], Content.E);
        }
    }
}
