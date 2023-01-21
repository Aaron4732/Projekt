package com.example.battelship;

public class Main {
    public static void main(String[] args) {

        //Create the gameboard for player1
        System.out.println("Player1 please place your ships");
        GameBoard gameBoard1 = new GameBoard();
        gameBoard1.printGameBoard();
        System.out.println();

        //Create the gameboard for player2
        System.out.println("Player2 please place your ships");
        GameBoard gameBoard2 = new GameBoard();
        gameBoard2.printGameBoard();
        System.out.println(

        );
        //play the game
        for (; ; ) {
            //make a shot on gameboard2
            System.out.println("Player1 please place your shot");
            gameBoard2.printGameBoard();
            gameBoard2.userTarget();
            gameBoard2.printGameBoard();

            if (gameBoard2.gameIsOver()) {
                //print the "won" message when the game is over
                System.out.println("Player1 you win the game");
                break;
            }

            //make a shot on gameboard1
            System.out.println("\nPlayer2 please place your shot");
            gameBoard1.printGameBoard();
            gameBoard1.userTarget();
            gameBoard1.printGameBoard();

            if (gameBoard1.gameIsOver()) {
                //print the "won" message when the game is over
                System.out.println("\nPlayer2 you win the game");
                break;
            }
        }
    }
}
