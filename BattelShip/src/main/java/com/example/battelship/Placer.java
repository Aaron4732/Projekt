package com.example.battelship;

import java.util.Scanner;

/**
 * contains all methods for initial choice and placement of the ships / checks for validity
 */
public class Placer {

    int shipsSize2 = Config.getShipsSize2();
    int shipsSize3 = Config.getShipsSize3();
    int shipsSize4 = Config.getShipsSize4();
    int shipsSize5 = Config.getShipsSize5();
    int shipsTotal = Config.getShipsTotal();

    int HitPoints;

    GameBoard gameBoard;

    int gameBoardLength = Config.getGameBoardLength();
    int gameBoardWidth = Config.getGameBoardLength();
    char ship = Config.getShip();

    int placedShips = 0;
    int startCoordinateX;
    int startCoordinateY;
    int horizontal = 0;
    int vertical = 0;
    int shipSize;

    /**
     * initialisation of placer object / take gameboard
     * @param gameBoard
     */
    public Placer(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        }

    /**
     * Terminal output for ship position and direction
     */
    public void placeShipsTerminal() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < shipsTotal; i++) {

            System.out.println("Available ships: \n(1) Place Speedboat  ++: " + shipsSize2 + "\n(2) Place Submarine  +++: " + shipsSize3 + "\n(3) Place Battleship ++++: " + shipsSize4 + "\n(4) Place Carrier    +++++: " + shipsSize5);

            for (;;) {
                System.out.println("Please select an available ship by writing its number into the console.");

                setShipSize(scanner.nextInt() + 1);         //directly inserting user input into shipSize


                if (shipAvailable(shipSize)) break;     //determining ship availability through method

                System.out.println("Ship is not available!");
            }
            reduceShip(shipSize);

            for (;;) {
                gameBoard.printGameBoardWithShips();
                System.out.println("Please select the start Position");

                System.out.print("Row:");
                setStartCoordinateY(scanner.nextInt() -1);

                System.out.print("Column:");
                setStartCoordinateX(scanner.nextInt() -1);

                while (horizontal < 1 && vertical < 1) {
                    System.out.print("Select the direction Down[D], Right[R]");
                    String direction = scanner.next();

                    switch (direction) {
                        case "D" -> setVertical(1);
                        case "R" -> setHorizontal(1);
                        default -> System.out.println("The input was not correct ");
                    }
                }

                if (positionFreeForShip()) break;       //method returns boolean, so simple statement
                System.out.println("The position is not available, select another one");
            }

            placeShip();
            gameBoard.printGameBoardWithShips();
        }
    }

    /**
     * returns wether if ships are still available
     * @param shipSize
     * @return
     */
    private boolean shipAvailable(int shipSize) {
        return switch (shipSize) {
            case 2 -> (shipsSize2 > 0);
            case 3 -> (shipsSize3 > 0);
            case 4 -> (shipsSize4 > 0);
            case 5 -> (shipsSize5 > 0);
            default -> false;
        };
    }

    /**
     * reduce amount of available ships after ship selection
     * @param shipSize
     */
    private void reduceShip(int shipSize) {
        switch (shipSize) {
            case 2 -> shipsSize2--;
            case 3 -> shipsSize3--;
            case 4 -> shipsSize4--;
            case 5 -> shipsSize5--;
        }
    }

    /**
     * checks placer selection of coordinates for validity
      * @return
     */
    private boolean positionFreeForShip() {
        //checking all variations that are outside of gameBoard
        if (
                startCoordinateX < 0 ||
                        startCoordinateX >= gameBoardLength ||
                        startCoordinateY < 0 ||
                        startCoordinateY >= gameBoardLength ||
                        startCoordinateX + shipSize * horizontal < 0 ||
                        startCoordinateX + shipSize * horizontal > gameBoardWidth ||
                        startCoordinateY + shipSize * vertical < 0 ||
                        startCoordinateY + shipSize * vertical > gameBoardWidth
        ) {
            return false;
        }

        //Check all fields which have to be free
        for (int i = -1; i < (shipSize -1)* vertical +3-1; i++) {

            //When the field is outside the grid, it gets ignored
            if (startCoordinateY +i < 0 || startCoordinateY +i >= gameBoardLength) continue;

            for (int k = -1; k < (shipSize -1)* horizontal +3-1; k++) {

                //When the field is outside the grid, it gets ignored
                if (startCoordinateX +k < 0 || startCoordinateX +k >= gameBoardWidth) continue;

                //return false when a field is not free
                if (gameBoard.getCharOfCoordinate(startCoordinateX + k, startCoordinateY +i) == ship) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     *takes user coordinates and modifies them with choice about direction / increments number of placed ships
     */
    private void placeShip() {
        for (int i = 0; i < shipSize; i++) {
            gameBoard.setCharOnCoordinate(startCoordinateX + horizontal * i, startCoordinateY + vertical * i, ship);  //hor/ver have own methods
        }
        placedShips++;
    }

    /**
     * sets values for horizontal positioning of the ship
     * @param horizontal
     */
    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
        this.vertical = 0;
    }

    /**
     * sets values for vertical positioning of the ship
     * @param vertical
     */
    public void setVertical(int vertical) {
        this.vertical = vertical;
        this.horizontal = 0;
    }

    /**
     * sets values for x coordinate
     * @param startCoordinateX
     */
    public void setStartCoordinateX(int startCoordinateX) {
        this.startCoordinateX = startCoordinateX;
    }

    /**
     * sets values for y coordinate
     * @param startCoordinateY
     */
    public void setStartCoordinateY(int startCoordinateY) {
        this.startCoordinateY = startCoordinateY;
    }

    /**
     * sets values for ship size
     * @param shipSize
     */
    public void setShipSize(int shipSize) {
        this.shipSize = shipSize;
    }


}


