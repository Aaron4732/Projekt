package com.example.battelship;

import java.util.Scanner;

public class Placer {
    int shipSize2;
    int shipSize3;
    int shipSize4;
    int shipSize5;
    int shipsTotal;

    int HitPoints;

    GameBoard gameBord;

    int gameBordLength;
    int gameBordWidth;
    
    char water;
    char ship;

    int placedShips = 0;
    int startCoordinateX;
    int startCoordinateY;
    int horizontal = 0;
    int vertical = 0;
    int shipSize;

    //Constructor for initialisation of necessary variables and objects
    public Placer(GameBoard gameBord, char water, char ship, int shipSize2, int shipSize3, int shipSize4, int shipSize5) {
        this.gameBord = gameBord;
        this.water = water;
        this.ship = ship;

        gameBordLength = gameBord.getGameBoardLength();
        gameBordWidth = gameBord.getGameBoardLength();
        this.shipSize2 = shipSize2;
        this.shipSize3 = shipSize3;
        this.shipSize4 = shipSize4;
        this.shipSize5 = shipSize5;

        shipsTotal = shipSize2 + shipSize3 + shipSize4 + shipSize5;
        }

    //initial request for player choice about ship size, position and orientation
    public void placeShipsTerminal() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < shipsTotal; i++) {
            System.out.println("Available ships: \nLength 2: " + shipSize2 + "\nLength 3: " + shipSize3 + "\nLength 4: " + shipSize4 + "\nLength 5: " + shipSize5);

            for (;;) {
                System.out.println("Pleace selct a available ship");
                setShipSize(scanner.nextInt());         //directly inserting user input into shipSize

                if (shipAvailable(shipSize)) break;     //determining ship availability through method

                System.out.println("Ship is not available!");
            }
            reduceShip(shipSize);

            for (;;) {
                gameBord.printGameBoardWithShips();
                System.out.println("Place select the start Position");

                System.out.print("X:");
                setStartCoordinateX(scanner.nextInt() -1);

                System.out.print("Y:");
                setStartCoordinateY(scanner.nextInt() -1);

                System.out.print("Select the direction Down[D], Right[R]");
                String direction = scanner.next();

                switch (direction) {
                    case "D" -> setVertical(1);
                    case "R" -> setHorizontal(1);
                }

                if (positionFreeForShip()) break;       //method returns boolean, so simple statement
            }

            placeShip();
            gameBord.printGameBoardWithShips();
        }
    }

    private boolean shipAvailable(int shipSize) {
        return switch (shipSize) {
            case 2 -> (shipSize2 > 0);
            case 3 -> (shipSize3 > 0);
            case 4 -> (shipSize4 > 0);
            case 5 -> (shipSize5 > 0);
            default -> false;
        };
    }

    private void reduceShip(int shipSize) {
        switch (shipSize) {
            case 2 -> shipSize2--;
            case 3 -> shipSize3--;
            case 4 -> shipSize4--;
            case 5 -> shipSize5--;
        }
    }

    private boolean positionFreeForShip() {
        //checking all variations that are outside of gameBoard
        if (
                startCoordinateX < 0 ||
                        startCoordinateX >= gameBordLength ||
                        startCoordinateY < 0 ||
                        startCoordinateY >= gameBordLength ||
                        startCoordinateX + shipSize * horizontal < 0 ||
                        startCoordinateX + shipSize * horizontal > gameBordWidth ||
                        startCoordinateY + shipSize * vertical < 0 ||
                        startCoordinateY + shipSize * vertical > gameBordWidth
        ) {
            return false;
        }

        //Check all fields which have to be free
        for (int i = -1; i < (shipSize -1)* vertical +3-1; i++) {

            //When the field is outside the grid, it gets ignored
            if (startCoordinateY +i < 0 || startCoordinateY +i >= gameBordLength) continue;

            for (int k = -1; k < (shipSize -1)* horizontal +3-1; k++) {

                //When the field is outside the grid, it gets ignored
                if (startCoordinateX +k < 0 || startCoordinateX +k >= gameBordWidth) continue;

                //return false when a field is not free
                if (gameBord.getCharOfCoordinate(startCoordinateX + k, startCoordinateY +i) == ship) {
                    return false;
                }
            }
        }

        return true;
    }

    private void placeShip() {
        for (int i = 0; i < shipSize; i++) {
            gameBord.setCharOnCoordinate(startCoordinateX + horizontal * i, startCoordinateY + vertical * i, ship);  //hor/ver have own methods
        }
        placedShips++;
    }

    public void setAllShipsTo0() {
        setShipSize2(0);
        setShipSize3(0);
        setShipSize4(0);
        setShipSize5(0);
    }


    // collection of methods for future expansions of the program / used methods in code instead of variables
    public void setShipSize2(int shipSize2) {
        this.shipSize2 = shipSize2;
        /*shipsTotal = shipSize2 + shipSize3 + shipSize4 + shipSize5;
        int HitPoints = shipSize2 *2  + shipSize3 *3 + shipSize4 *4 + shipSize5 *5;*/
    }

    public void setShipSize3(int shipSize3) {
        this.shipSize3 = shipSize3;
        /*shipsTotal = shipSize2 + shipSize3 + shipSize4 + shipSize5;
        int shipsHitPoints = shipSize2 *2  + shipSize3 *3 + shipSize4 *4 + shipSize5 *5;*/
    }

    public void setShipSize4(int shipSize4) {
        this.shipSize4 = shipSize4;
        /*shipsTotal = shipSize2 + shipSize3 + shipSize4 + shipSize5;
        int shipsHitPoints = shipSize2 *2  + shipSize3 *3 + shipSize4 *4 + shipSize5 *5;*/
    }

    public void setShipSize5(int shipSize5) {
        this.shipSize5 = shipSize5;
        /*shipsTotal = shipSize2 + shipSize3 + shipSize4 + shipSize5;
        int shipsHitPoints = shipSize2 *2  + shipSize3 *3 + shipSize4 *4 + shipSize5 *5;*/
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
        this.vertical = 0;
    }

    public void setVertical(int vertical) {
        this.vertical = vertical;
        this.horizontal = 0;
    }

    public void setStartCoordinateX(int startCoordinateX) {
        this.startCoordinateX = startCoordinateX;
    }

    public void setStartCoordinateY(int startCoordinateY) {
        this.startCoordinateY = startCoordinateY;
    }

    public void setShipSize(int shipSize) {
        this.shipSize = shipSize;
    }


}


