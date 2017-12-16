package tictactoe;
import java.util.Scanner;

class Input {

    int[] inputCoords(int[] alias) {
        int coordX;
        int coordY;
        int[] buffer = alias;
        coordY = buffer[0];
        coordX = buffer[1];
        //checking for free indexes in array (game will not continue without player move)
        while (Static.getGameField()[coordY][coordX] == '0' || Static.getGameField()[coordY][coordX] == 'X') {
            System.out.println("Wrong value! Players already make move here");

            buffer = inputCoords(alias(scanner()));
            coordY = buffer[0];
            coordX = buffer[1];
        }

        return new int[]{coordY, coordX};
    }

    String scanner() {
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
        return input;
    }

    int[] alias(String input) {
        int coordX = 0;
        int coordY = 0;

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

}