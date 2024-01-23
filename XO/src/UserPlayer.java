//Naim Moshe 315852269 & Ofir Biton 208582494
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserPlayer extends Player {
    private final Scanner scan;

    public UserPlayer(Content player, Game game) {
        super(player, game);
        this.scan = new Scanner(System.in);
    }

    @Override
    public void run() {
        execution();
    }

    private synchronized void execution() {
        while (!game.getStop()) {
            if(game.getTurn() == contentType){
                synchronized (game) {
                    Location[] freeCells = game.getFreeCells();
                    if (freeCells.length > 0 && !game.getStop()) {
                        makeMove(freeCells);
                        game.printBoard();

                        if (checkIfWin(contentType)) {
                            System.out.println("Player " + contentType + " wins!");
                            game.stop();
                        }
                    } else if (game.getStop()) {
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
    public synchronized void makeMove(Location[] freeLocations) {
        int choice = getChoice(freeLocations);
        game.getGameBoard()[freeLocations[choice].getX()][freeLocations[choice].getY()] = contentType;
        System.out.println("Player " + contentType + " did a move.");
        this.game.setCurrentPlayer((game.player1.contentType == contentType) ? game.player2.contentType : game.player1.contentType);

    }

    //Pick the free coordinate
    private synchronized int getChoice(Location[] freeLocations) {
        System.out.println("Select index: ");
        for (int i = 0; i < freeLocations.length; i++) {
            System.out.println((i + 1) + " -> " + freeLocations[i]);
        }

        int choice = 0;
        boolean isValid = false;

        while(!isValid) {
            try {
                choice = scan.nextInt();
                while (choice < 1 || choice > freeLocations.length) {
                    System.out.print("Out of bounds index, pick again: ");
                    choice = scan.nextInt();
                }
                isValid = true;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer!");
                scan.nextLine();
            }

        }
        return choice-1;
    }
}
