//Naim Moshe 315852269 & Ofir Biton 208582494
import java.util.Random;
public class SelfPlayer extends Player{
    public SelfPlayer(Content player, Game game) {
        super(player, game);
    }

    @Override
    public void run() {
        execution();

    }

    private synchronized void execution() {
        while(!game.getStop()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (game.getTurn() == contentType) {
                synchronized (game) {
                    Location[] freeCells = game.getFreeCells();
                    if (freeCells.length > 0 && !game.getStop()) {
                        makeMove(freeCells);
                        game.printBoard();

                        if (checkIfWin(contentType)) {
                            System.out.println("Player " + contentType + " wins!");
                            game.stop();
                        }
                    }

                    else if (game.getStop()) {
                        break;
                    } else {
                        System.out.println("Board is full!\nNow is a tie, next time there will be a Winner!");
                        game.stop();
                        break;
                    }
                }
            }
        }
    }

    //Make the next move
    @Override
    public synchronized void makeMove(Location[] freeLocations){
        Random random = new Random();
        Location coordinate = new Location(freeLocations[random.nextInt(freeLocations.length)]);
        game.getGameBoard()[coordinate.getX()][coordinate.getY()] = contentType;
        System.out.println("Player " + contentType + " did a move.");

        this.game.setCurrentPlayer((game.player1.contentType == contentType) ? game.player2.contentType : game.player1.contentType);
    }
}
