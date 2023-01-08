package com.example.battelship;

import java.util.Arrays;
import static com.example.battelship.Ships.generateShipCoordinates;

public class GameBoard {

    char[][] gameBoard;

    int gameBoardLength;
    char water;
    char ship;

    char miss;

    char hit;
    int shipsWhitSize2;
    int shipsWhitSize3;
    int shipsWhitSize4;
    int shipsWhitSize5;
    int shipNumber;

    int undetectedShipNumber;

    int[] guessCoordinates;

    char locationViewUpdate;

    public GameBoard(int gameBoardLength, char water, char ship, char hit, char miss, int shipsWhitSize2, int shipsWhitSize3, int shipsWhitSize4, int shipsWhitSize5) {

        this.gameBoardLength = gameBoardLength;
        this.water = water;
        this.ship = ship;
        this.hit = hit;
        this.miss = miss;
        this.shipsWhitSize2 = shipsWhitSize2;
        this.shipsWhitSize3 = shipsWhitSize3;
        this.shipsWhitSize4 = shipsWhitSize4;
        this.shipsWhitSize5 = shipsWhitSize5;

        this.shipNumber= shipsWhitSize2 *2  + shipsWhitSize3 *3 + shipsWhitSize4 *4 + shipsWhitSize5 *5;
        this.undetectedShipNumber = shipNumber;

        gameBoard = new char[gameBoardLength][gameBoardLength];
        for (char[] row : gameBoard) {
            Arrays.fill(row, water);
        }

        Placer placer = new Placer(this, water, ship, shipsWhitSize2, shipsWhitSize3, shipsWhitSize4, shipsWhitSize5);
        placer.placeShipsTerminal();
    }

    public void printGameBoard()
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

    public void printGameBoardWithShips()
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

    public void placeShipsRandom() {
        int placedShips = 0;
        int gameBoardLength = gameBoard.length;
        while (placedShips < shipNumber) {
            int[] location = generateShipCoordinates(gameBoardLength);
            char possiblePlacement = gameBoard[location[0]][location[1]];
            if (possiblePlacement == water) {
                gameBoard[location[0]][location[1]] = ship;
                placedShips++;
            }
        }
    }

    private void updateGameBoard() {
        int row = guessCoordinates[0];
        int col = guessCoordinates[1];
        gameBoard[row][col] = locationViewUpdate;
    }

    private void checkCoordinatesOnGameBord() {
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
            target = miss;
        } else
        {
            message = "Already hit!";
        }
        System.out.println(message);

        locationViewUpdate = target;
    }
    public void userTarget() {
        guessCoordinates = UserInput.getUserCoordinates(gameBoardLength);
        checkCoordinatesOnGameBord();
        if (locationViewUpdate == hit)
        {
            undetectedShipNumber--;
        }
        updateGameBoard();
    }

    public int getGameBoardLength() {
        return gameBoardLength;
    }

    public char getCharOfCoordinate(int X, int Y) {
        return gameBoard[Y][X];
    }

    public void setCharOnCoordinate(int X, int Y, char newValue) {
        gameBoard[Y][X] = newValue;
    }

    public boolean gameIsOver() {
        return (undetectedShipNumber <= 0);
    }
}
