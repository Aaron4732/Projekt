package com.example.battelship;

import java.util.Scanner;

public class UserInput {

    public static int[] getUserCoordinates(int gameBoardLength) {
        int row;
        int col;

        do
        {
            System.out.println("Row: ");
            row = new Scanner(System.in).nextInt();
        } while (row < 1 || row > gameBoardLength +1);

        do
        {
            System.out.println("Column: ");
            col = new Scanner(System.in).nextInt();
        } while (col < 1 || col > gameBoardLength +1 );
        return new int[] {row - 1, col - 1 };
    }
}
