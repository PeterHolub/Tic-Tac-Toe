package tictactoe;

import java.io.IOException;
import java.util.Scanner;

class Input {
     private Messages messages = new Messages();
    int[] inputCoords(int[] alias) throws IOException {

        int coordX;
        int coordY;

        coordY = alias[0];
        coordX = alias[1];
        //checking for free indexes in array (game will not continue without player move)
        while (Static.getGameField()[coordY][coordX] == Static.PLAYER_TWO_ALIAS || Static.getGameField()[coordY][coordX] == Static.PLAYER_ONE_ALIAS) {
            System.out.println(messages.getMessages().getProperty("wrongValue"));
//  array buffer declaration to escape from endless loop after recursion
            int[] buffer = inputCoords(alias(scanner()));
            coordY = buffer[0];
            coordX = buffer[1];
        }

        return new int[]{coordY, coordX};
    }

    String scanner() throws IOException {
        String input;
//        String inputMessage = "Enter the value to place players move (from 1 to 9)";
        Scanner sc1 = new Scanner(System.in);
        System.out.println(messages.getMessages().getProperty("enterValue"));
        input = sc1.next();
        //validation of input characters
        while (!input.matches("[1-9]")) {
            System.out.println(messages.getMessages().getProperty("wrongShort"));
            System.out.println(messages.getMessages().getProperty("enterValue"));
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