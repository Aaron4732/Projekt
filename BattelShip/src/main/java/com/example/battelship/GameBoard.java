package com.example.battelship;

import java.util.Arrays;

public class GameBoard {

    char[][] gameBoard;

    int gameBoardLength = Config.getGameBoardLength();
    char water = Config.getWater();
    char ship = Config.getShip();
    char miss = Config.getMiss();
    char hit = Config.getHit();
    int undetectedShipNumber = Config.getShipNumber();

    int[] guessCoordinates;

    char locationViewUpdate;

    public GameBoard() {

        gameBoard = new char[gameBoardLength][gameBoardLength];

        //Filling gameboard with water
        for (char[] row : gameBoard) {
            Arrays.fill(row, water);
        }

        Placer placer = new Placer(this);
        placer.placeShipsTerminal();
    }

    public void printGameBoard()
    //Method to create console layout of gameboard
    {
        int gameBoardLength = gameBoard.length;
        //creating variable for gameboard.length for performance.
        System.out.print("  ");

        for (int i = 0; i < gameBoardLength; i++)
        {
            System.out.print(i + 1 + " ");
            //creating column coordinates
        }
        System.out.println();
        for(int row = 0; row < gameBoardLength; row++)
        {
            System.out.print(row + 1 + " ");
            //creating row coordinates

            for (int col = 0; col < gameBoardLength; col++)
            {
                char position = gameBoard[row][col];
                if(position == ship)
                {
                    System.out.print(water + " ");
                    //Print undetected ships as water

                } else {
                    System.out.print(position + " ");
                }
            }
            System.out.println();
        }
    }

    public void printGameBoardWithShips()
    // Method for printing gameboard with ships for placing the ships. Like the 'printGameBoard' method, but with ships visible.
    {
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

    /* Method is currently not in use. Would be needed if 'computer' player needs to be installed.
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
    */

    private void updateGameBoard() {
        //Method to change User guesses for row and col values into gameBoard coordinates.
        int row = guessCoordinates[0];
        int col = guessCoordinates[1];
        gameBoard[row][col] = locationViewUpdate;
    }

    private void checkCoordinatesOnGameBoard() {
        //Method to check if User guess (input coordinates) are a hit or a miss.
        String message;
        int row = guessCoordinates[0];
        int col = guessCoordinates[1];
        char target = gameBoard[row][col];
        //Both guess coordinates are combined for a specific target on gameboard.

        if (target == ship)
        {
            message = "    Hit!";
            target = hit;
        } else if (target == water)
        {
            message = "  Miss! :(";
            target = miss;
        } else
        {
            message = "Already hit!";
        }
        System.out.println("\n************");
        System.out.println(message);
        System.out.println("************\n");


        locationViewUpdate = target;
    }
    public void userTarget() {
        guessCoordinates = UserInput.getUserCoordinates(gameBoardLength);
        //Getting the User input coordinates.
        checkCoordinatesOnGameBoard();
        if (locationViewUpdate == hit)
        {
            undetectedShipNumber--;
            //If locationViewUpdate (target) is a hit, ship number will be reduced by 1.
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
        //method for checking of all ships have been hit and game is over.
        return (undetectedShipNumber <= 0);
    }
}
