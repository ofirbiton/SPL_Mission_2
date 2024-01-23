/*Naim Moshe 315852269 & Ofir Biton 208582494
https://github.com/ofirbiton/SPL_Mission_2.git */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game;
        System.out.println("Welcome To TicTacToe Game!\nPlease select you game version:\n1 -> Self Game\n2 -> User Game");
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        boolean isValid = false;
        while (!isValid){
            try{
                choice = scanner.nextInt();
                while (!(choice == 1 || choice == 2)){
                    System.out.println("Pick only 1 or 2..");
                    choice = scanner.nextInt();
                }
                isValid = true;
            }
            catch (InputMismatchException e){
                System.out.println("Pick only 1 or 2..");
                scanner.nextLine();
            }
        }

        if(choice == 1) game = new SelfGame();
        else game = new UserGame();

        Thread thread1 = new Thread(game.getPlayer1());
        Thread thread2 = new Thread(game.getPlayer2());

        thread1.start();
        thread2.start();


    }
}