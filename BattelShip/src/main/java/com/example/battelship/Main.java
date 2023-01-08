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
        GameBoard gameBoard1 = new GameBoard (gameBoardLength, water, ship, hit, miss, shipsSize2, shipsSize3, shipsSize4, shipsSize5 );
        gameBoard1.printGameBoard();

        //play the game
        while (!gameBoard1.gameIsOver())
        {
            //make a shut on gamebord1
            gameBoard1.userTarget();
            gameBoard1.printGameBoard();
        }
        //print the "won" massage when the game is over
        System.out.println("You Won!");
    }
}
