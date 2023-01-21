package com.example.battelship;


public class Config {
    static int shipsSize2 = 0;
    static int shipsSize3 = 1;
    static int shipsSize4 = 0;
    static int shipsSize5 = 0;

    static int shipsTotal = shipsSize2 + shipsSize3 + shipsSize4 + shipsSize5;

    static int shipNumber = shipsSize2 *2  + shipsSize3 *3 + shipsSize4 *4 + shipsSize5 *5;

    //Symbols for the gamebord
    static char water = 126;
    static char ship = 'S';
    static char hit = 'X';
    static char miss = 'O';

    static int gameBoardLength = 4;
    static int GameBoardHight = 4;
    public static int getShipsSize2() {
        return shipsSize2;
    }
    public static int getShipsSize3() {
        return shipsSize3;
    }

    public static int getShipsSize4() {
        return shipsSize4;
    }

    public static int getShipsSize5() {
        return shipsSize5;
    }

    public static int getShipsTotal() {
        return shipsTotal;
    }

    public static int getShipNumber() {
        return shipNumber;
    }

    public static char getWater() {
        return water;
    }

    public static char getShip() {
        return ship;
    }

    public static char getHit() {
        return hit;
    }

    public static char getMiss() {
        return miss;
    }

    public static int getGameBoardLength() {
        return gameBoardLength;
    }

    public static int getGameBoardHight() {
        return GameBoardHight;
    }
}


