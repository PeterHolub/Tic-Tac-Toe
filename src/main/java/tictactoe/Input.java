package tictactoe;

import java.util.Scanner;

class Input extends Main {

    private int[] inputCoords() {
        int coordX;
        int coordY;
        int[] buffer = alias();
        coordY = buffer[0];
        coordX = buffer[1];
        //checking for free indexes in array (game will not continue without player move)
        while (gameField[coordY][coordX] == '0' || gameField[coordY][coordX] == 'X') {
            System.out.println("Wrong value! Players already make move here");
            buffer = alias();
            coordY = buffer[0];
            coordX = buffer[1];
        }
        return new int[]{coordY, coordX};
    }

    private int[] alias() {
        int coordX = 0;
        int coordY = 0;
        String input;
        String inputMessage = "Enter the value to place players move (from 1 to 9)";
        Scanner sc1 = new Scanner(System.in);
        System.out.println(inputMessage);
        input = sc1.next();
        //validation of input characters
        while (!input.matches("[1-9]")) {
            System.out.println("Wrong value!");
            System.out.println(inputMessage);
            input = sc1.next();
        }
        //switch case for alias
        switch (input) {
            case "1": {
                coordY = 0;
                coordX = 0;
                break;
            }
            case "2": {
                coordY = 0;
                coordX = 1;
                break;
            }
            case "3": {
                coordY = 0;
                coordX = 2;
                break;
            }
            case "4": {
                coordY = 1;
                coordX = 0;
                break;
            }
            case "5": {
                coordY = 1;
                coordX = 1;
                break;
            }
            case "6": {
                coordY = 1;
                coordX = 2;
                break;
            }
            case "7": {
                coordY = 2;
                coordX = 0;
                break;
            }
            case "8": {
                coordY = 2;
                coordX = 1;
                break;
            }
            case "9": {
                coordY = 2;
                coordX = 2;
                break;
            }
        }
        return new int[]{coordY, coordX};
    }

    void playerMove(char playerAlias) {
        System.out.println("Player " + playerAlias + " move ");
        printVisual(getFieldMap());
        int[] buffer = inputCoords();
        int coordY = buffer[0];
        int coordX = buffer[1];
        gameField[coordY][coordX] = playerAlias;
    }
}
