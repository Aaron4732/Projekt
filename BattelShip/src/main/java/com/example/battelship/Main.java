package com.example.battelship;

public class Main {
    public static void main(String[] args) {

        //Create the gamebord for player1
        GameBoard gameBoard1 = new GameBoard();
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
