package com.example.battelship;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
    
        //Create the gameboard for player1
        System.out.println("Player1 place your ships\n");
        GameBoard gameBoard1 = new GameBoard();
        GameBoard.clearTerminal();

        //Create the gameboard for player2
        System.out.println("Player2 place your ships\n");

        GameBoard gameBoard2 = new GameBoard();
        GameBoard.clearTerminal();
        //play the game
        for (;;){
            //make a shot on gameboard2
            System.out.println("\nPlayer1 place your shot");
            gameBoard2.printGameBoard();
            gameBoard2.userTarget();
            gameBoard2.printGameBoard();

            if (gameBoard2.gameIsOver()) {
                //print the "won" message when the game is over
                System.out.println();
                System.out.println("                |    |    |  ");
                System.out.println("               )_)  )_)  )_) ");
                System.out.println("              )___))___))___)                    CONGRATULATIONS");
                System.out.println("             )____)____)_____)                       PLAYER 1");
                System.out.println("           _____|____|____|_____                   YOU ARE THE");
                System.out.println("  ---------\\                   /---------             WINNER");
                System.out.println("     ^^^^^ ^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("         ^^^^      ^^^^     ^^^    ^^");
                System.out.println("               ^^^^      ^^^");
                break;
            }

            //make a shot on gameboard1
            System.out.println("\nPlayer2 place your shot");
            gameBoard1.printGameBoard();
            gameBoard1.userTarget();
            gameBoard1.printGameBoard();

            if (gameBoard1.gameIsOver()) {
                //print the "won" message when the game is over
                System.out.println();
                System.out.println("                |    |    |  ");
                System.out.println("               )_)  )_)  )_) ");
                System.out.println("              )___))___))___)                    CONGRATULATIONS");
                System.out.println("             )____)____)_____)                       PLAYER 2");
                System.out.println("           _____|____|____|_____                   YOU ARE THE");
                System.out.println("  ---------\\                   /---------             WINNER");
                System.out.println("     ^^^^^ ^^^^^^^^^^^^^^^^^^^^^");
                System.out.println("         ^^^^      ^^^^     ^^^    ^^");
                System.out.println("               ^^^^      ^^^");
                break;
            }
        }
    }
}
