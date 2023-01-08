package com.example.battelship;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int gameBoardLength = 8;
        char water = '-';
        char ship = 'S';
        char hit = 'X';
        char miss = 'O';

        int shipsWhitSize2 = 0;
        int shipsWhitSize3 = 1;
        int shipsWhitSize4 = 0;
        int shipsWhitSize5 = 0;

        System.out.println("Player1 place your ships");
        GameBoard gameBoard1 = new GameBoard (gameBoardLength, water, ship, hit, miss, shipsWhitSize2, shipsWhitSize3, shipsWhitSize4, shipsWhitSize5 );

        System.out.println("Player2 place your ships");
        GameBoard gameBoard2 = new GameBoard (gameBoardLength, water, ship, hit, miss, shipsWhitSize2, shipsWhitSize3, shipsWhitSize4, shipsWhitSize5 );


        while (!gameBoard1.gameIsOver() && !gameBoard2.gameIsOver())
        {
            System.out.println("Player1 make your shot");
            gameBoard2.printGameBoard();
            gameBoard2.userTarget();

            System.out.println("Player2 make your shot");
            gameBoard1.printGameBoard();
            gameBoard1.userTarget();


        }
        System.out.println("You Won!");
    }
}
