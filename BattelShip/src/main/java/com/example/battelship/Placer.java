package com.example.battelship;

import java.util.Scanner;

public class Placer {

    int shipsSize2 = Config.getShipsSize2();
    int shipsSize3 = Config.getShipsSize3();
    int shipsSize4 = Config.getShipsSize4();
    int shipsSize5 = Config.getShipsSize5();
    int shipsTotal = Config.getShipsTotal();

    //int HitPoints;            //may be of use later on

    GameBoard gameBord;

    int gameBordLength = Config.getGameBoardLength();
    int gameBordWidth = Config.getGameBoardHight();
    char ship = Config.getShip();

    int placedShips = 0;
    int startCoordinateX;
    int startCoordinateY;
    int horizontal = 0;
    int vertical = 0;
    int shipSize;

    //Constructor for initialisation of necessary variables and objects
    public Placer(GameBoard gameBord) {
        this.gameBord = gameBord;
        }

    //initial request for player choice about ship size, position and orientation
    public void placeShipsTerminal() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < shipsTotal; i++) {

            System.out.println("Available ships: \n[2] Length 2: " + shipsSize2 + "\n[3] Length 3: " + shipsSize3 + "\n[4] Length 4: " + shipsSize4 + "\n[5] Length 5: " + shipsSize5);

            for (;;) {
                System.out.println("Pleace selct a available ship by number");

                setShipSize(scanner.nextInt());         //directly inserting user input into shipSize

                if (shipAvailable(shipSize)) break;     //determining ship availability through method

                System.out.println("Ship is not available!");
            }
            reduceShip(shipSize);

            for (;;) {
                gameBord.printGameBoardWithShips();
                System.out.println("\nSelect the start Position");

                System.out.print("Column:");
                setStartCoordinateX(scanner.nextInt() -1);

                System.out.print("Row:");
                setStartCoordinateY(scanner.nextInt() -1);

                System.out.print("\nSelect the direction: Down[D], Right[R]");
                String direction = scanner.next();

                switch (direction) {
                    case "D" -> setVertical(1);
                    case "d" -> setVertical(1);
                    case "R" -> setHorizontal(1);
                    case "r" -> setHorizontal(1);
                }

                if (positionFreeForShip()) break;       //method returns boolean, so simple statement
                System.out.println("The Position is not availibal, select a other one");
            }

            placeShip();
            gameBord.printGameBoardWithShips();
        }
    }

    private boolean shipAvailable(int shipSize) {
        return switch (shipSize) {
            case 2 -> (shipsSize2 > 0);
            case 3 -> (shipsSize3 > 0);
            case 4 -> (shipsSize4 > 0);
            case 5 -> (shipsSize5 > 0);
            default -> false;
        };
    }

    private void reduceShip(int shipSize) {
        switch (shipSize) {
            case 2 -> shipsSize2--;
            case 3 -> shipsSize3--;
            case 4 -> shipsSize4--;
            case 5 -> shipsSize5--;
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


