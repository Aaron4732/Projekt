package com.example.battelship;

import java.util.Random;

/**
 * old class used before version with user input / generating random coordinates
 */
public class Ships {
    /**
     * coordinates get randomly generated and returned in an int array
      * @param gameBoardLength
     * @return
     */

    public static int[] generateShipCoordinates(int gameBoardLength) {
        //the method generate random ship coordinates 1x1 and return them in a list

        //create the list for return
        int[] coordinates = new int[2];

        //generate a coordinationpoint for every dimension in the list "coordinates"
        for (int i = 0; i < coordinates.length; i++)
        {
            //generate the point
            coordinates[i] = new Random().nextInt(gameBoardLength);
        }
        return coordinates;
    }
}
