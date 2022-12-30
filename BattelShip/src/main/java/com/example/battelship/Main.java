package com.example.battelship;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int gameBoardLength = 4;
        char water = '-';
        char ship = 'S';
        char hit = 'X';
        char miss = 'O';
        int shipNumber = 3;

        char[][] gameBoard = GameBoard.createGameBoard(gameBoardLength, water, ship, shipNumber);
        printGameBoard(gameBoard, water, ship);
        int undetectedShipNumber = shipNumber;

        while (undetectedShipNumber < 0)
        {
            int[] guessCoordinates = UserInput.getUserCoordinates(gameBoardLength);
            char locationViewUpdate = evaluateGuessAndGetTheTarget(guessCoordinates, gameBoard, ship, water, hit, miss);
            if (locationViewUpdate == hit)
            {
                undetectedShipNumber--;
            }
            gameBoard = updateGameBoard(gameBoard, guessCoordinates, locationViewUpdate);
            printGameBoard(GameBoard, water, ship)
        }
    }

    private static char[][] updateGameBoard(char[][] gameBoard, int[] guessCoordinates, char locationViewUpdate) {
        int row = guessCoordinates[0];
        int col = guessCoordinates[1];
        gameBoard[row][col] = locationViewUpdate;
        return gameBoard;
    }

    private static char evaluateGuessAndGetTheTarget(int[] guessCoordinates, char[][] gameBoard, char ship, char water, char hit, char miss) {
        String message;
        int row = guessCoordinates[0];
        int col = guessCoordinates[1];
        char target = gameBoard[row][col];

        if (target == ship)
        {
            message = "Hit!";
            target = hit;
        } else if (target == water)
        {
            message = "Miss!";
            target = water;
        } else
        {
            message = "Already hit!";
        }
        System.out.println(message);

        return target;

    }


}
