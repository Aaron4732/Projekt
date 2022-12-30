package com.example.battelship;

import java.util.Random;

public class Ships {

    public static char[][] placeShips(char[][] gameBoard, int shipNumber, char water, char ship){
        int placedShips = 0;
        int gameBoardLength = gameBoard.length;
        while (placedShips < shipNumber)
        {
            int[] location = generateShipCoordinates(gameBoardLength);
            char possiblePlacement = gameBoard[location[0]][location[1]];
            if (possiblePlacement == water)
            {
                gameBoard[location[0]][location[1]] = ship;
                placedShips++;
            }
        }
    }

    private static int[] generateShipCoordinates(int gameBoardLength) {
        int[] coordinates = new int[2];
        for (int i = 0; i < coordinates.length; i++)
        {
            coordinates[i] = new Random().nextInt(gameBoardLength);
        }
        return coordinates;
    }
}
