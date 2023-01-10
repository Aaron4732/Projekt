package com.example.battelship;

public class Main {
    public static void main(String[] args) {
        int gameBoardLength = 4;

        //Symbols for the gamebord
        char water = '-';
        char ship = 'S';
        char hit = 'X';
        char miss = 'O';

        //Set the number of ship availability ships
        int shipsSize2 = 0;
        int shipsSize3 = 1;
        int shipsSize4 = 0;
        int shipsSize5 = 0;

        //Create the gamebord for player1
        System.out.println("Player1 please place your ships");
        GameBoard gameBoard1 = new GameBoard (gameBoardLength, water, ship, hit, miss, shipsSize2, shipsSize3, shipsSize4, shipsSize5 );
        gameBoard1.printGameBoard();
        System.out.println();

        //Create the gamebord for player2
        System.out.println("Player2 please place your ships");
        GameBoard gameBoard2 = new GameBoard (gameBoardLength, water, ship, hit, miss, shipsSize2, shipsSize3, shipsSize4, shipsSize5 );
        gameBoard2.printGameBoard();
        System.out.println(

        );
        //play the game
        for (;;){
            //make a shut on gamebord2
            System.out.println("Player1 please place your shot");
            gameBoard2.printGameBoard();
            gameBoard2.userTarget();
            gameBoard2.printGameBoard();

            if (gameBoard2.gameIsOver()) {
                //print the "won" massage when the game is over
                System.out.println("Player1 you win the game");
                break;
            }

            //make a shut on gamebord1
            System.out.println("\nPlayer2 please place your shot");
            gameBoard1.printGameBoard();
            gameBoard1.userTarget();
            gameBoard1.printGameBoard();

            if (gameBoard1.gameIsOver()) {
                //print the "won" massage when the game is over
                System.out.println("\nPlayer2 you win the game");
                break;
            }
        }
    }
}
