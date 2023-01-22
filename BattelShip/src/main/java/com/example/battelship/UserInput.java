package com.example.battelship;

import java.util.Scanner;

/**
 * class with a method to read user input
 */

public class UserInput {

    /**
     * get x and y coordinate and return them in an int array
     * @param gameBoardLength
     * @return
     */


    public static int[] getUserCoordinates() {
        //ask the user in the terminal row and column coordinates and return them in a list

        //static variables for the coordinates
        int coordinateY;
        int coordinateX;

        int gameBoardLength = Config.getGameBoardLength();

        do
        {
            //aks the user for the coordinates of the column
            System.out.println("Column: ");
            coordinateX = new Scanner(System.in).nextInt();
            //check that the input coordinates are not smaller than 0 and not bigger than the gamebord
        } while (coordinateX < 1 || coordinateX > gameBoardLength +1 );

        do
        {
            //ask user for the coordinates of the row
            System.out.println("Row: ");
            coordinateY = new Scanner(System.in).nextInt();
            //check that the input coordinates are not smaller than 0 and not bigger than the gamebord
        } while (coordinateY < 1 || coordinateY > gameBoardLength +1);

        //return the coordinates of the user input
        return new int[] {coordinateY - 1, coordinateX - 1 };
    }
}
