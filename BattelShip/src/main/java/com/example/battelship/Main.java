package com.example.battelship;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int gameBoardLength = 4;
        char water = '-';
        char ship = 'S';
        char hit = 'X';
        char miss = 'O';

        int shipsWhitSize2 = 0;
        int shipsWhitSize3 = 1;
        int shipsWhitSize4 = 0;
        int shipsWhitSize5 = 0;


        GameBoard gameBoard1 = new GameBoard (gameBoardLength, water, ship, hit, miss, shipsWhitSize2, shipsWhitSize3, shipsWhitSize4, shipsWhitSize5 );
        gameBoard1.printGameBoard();

        while (!gameBoard1.gameIsOver())
        {
            gameBoard1.userTarget();
            gameBoard1.printGameBoard();
        }
        System.out.println("You Won!");
    }
}
