package com.example.battelship;

import java.util.Random;

public class Ships {

    public static int[] generateShipCoordinates(int gameBoardLength) {
        int[] coordinates = new int[2];
        for (int i = 0; i < coordinates.length; i++)
        {
            coordinates[i] = new Random().nextInt(gameBoardLength);
        }
        return coordinates;
    }
}
