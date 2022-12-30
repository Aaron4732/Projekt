package com.example.battelship;

import java.util.Arrays;
import static com.example.battelship.Ships.generateShipCoordinates;

public class GameBoard {
    public static char[][] createGameBoard(int gameBoardLength, char water, char ship, int shipNumber) {
        char[][] gameBoard = new char[gameBoardLength][gameBoardLength];
        for (char[] row : gameBoard) {
            Arrays.fill(row, water);
        }

        Placer placer = new Placer(gameBoard, water, ship);
        placer.placeShipsTerminal();

        return placer.returnGameBord();
    }

    public static void printGameBoard(char[][] gameBoard, char water, char ship)
    {
        int gameBoardLength = gameBoard.length;
        System.out.print("  ");

        for (int i = 0; i < gameBoardLength; i++)
        {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for(int row = 0; row < gameBoardLength; row++)
        {
            System.out.print(row + 1 + " ");
            for (int col = 0; col < gameBoardLength; col++)
            {
                char position = gameBoard[row][col];
                if(position == ship)
                {
                    System.out.print(water + " ");
                } else {
                    System.out.print(position + " ");
                }
            }
            System.out.println();
        }
    }

    public static void printGameBoardWhitShips(char[][] gameBoard, char water, char ship)
    {
        int gameBoardLength = gameBoard.length;
        System.out.print("  ");

        for (int i = 0; i < gameBoardLength; i++)
        {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for(int row = 0; row < gameBoardLength; row++) {
            System.out.print(row + 1 + " ");
            for (int col = 0; col < gameBoardLength; col++) {
                char position = gameBoard[row][col];

                System.out.print(position + " ");
                }

            System.out.println();
            }
        }

    public static char[][] placeShips(char[][] gameBoard, char water, char ship) {
        return gameBoard;
    }


}
