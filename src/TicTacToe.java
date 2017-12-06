import java.util.Scanner;

public class TicTacToe {
    private static int numberOfmoves;
    private static char[][] gameField =
            {{'*', '*', '*'},
                    {'*', '*', '*'},
                    {'*', '*', '*'}};
    private static char[][] fieldMap =
            {{'1', '2', '3'},
                    {'4', '5', '6'},
                    {'7', '8', '9'}};

    private static int[] inputCoords() {
        int coordX;
        int coordY;
        int[] buffer = Alias();
        coordY = buffer[0];
        coordX = buffer[1];
        //checking for free indexes in array (game will not continue without player move)
        while (gameField[coordY][coordX] == '0' || gameField[coordY][coordX] == 'X') {
            System.out.println("Wrong value! Players already make move here");
            buffer = Alias();
            coordY = buffer[0];
            coordX = buffer[1];
        }
        return new int[]{coordY, coordX};
    }

    private static int[] Alias() {
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

    private static void playerMove(char playerAlias) {
        System.out.println("Player " + playerAlias + " move ");
        printVisual(fieldMap);
        int[] buffer = inputCoords();
        int coordY = buffer[0];
        int coordX = buffer[1];
        gameField[coordY][coordX] = playerAlias;
    }

    private static void printVisual(char[][] arrayTwoD) {
        if (arrayTwoD == fieldMap)
            System.out.println("Here is field map for players moves:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arrayTwoD[i][j]);
            }
            System.out.println();
        }
    }

    private static char gameStatus() {
        char winner = ' ';
        //horizon lines check
        for (int i = 0; i < 3; i++) {
            if (gameField[i][0] == gameField[i][1] && gameField[i][1] == gameField[i][2]
                    && gameField[i][0] != '*') {
                winner = gameField[i][0];// return value from array
                break;
            }
        }
        // vertical lines check
        if (winner == ' ') {
            for (int i = 0; i < 3; i++) {
                if (gameField[0][i] == gameField[1][i] && gameField[1][i] == gameField[2][i]
                        && gameField[0][i] != '*') {
                    winner = gameField[0][i];
                    break;
                }
            }
        }
        // Х00
        // 0Х0
        // 00Х
        if (winner == ' ') {
            if (gameField[0][0] == gameField[1][1] && gameField[1][1] == gameField[2][2]
                    && gameField[0][0] != '*') {
                winner = gameField[0][0];
            }
        }
        // 00X
        // 0X0
        // Х00
        if (winner == ' ') {
            if (gameField[0][2] == gameField[1][1] && gameField[1][1] == gameField[2][0]
                    && gameField[0][2] != '*') {
                winner = gameField[0][2];
            }
        }
        // returns space if no winner
        System.out.println(winner);
        return winner;
    }

    private static boolean canMove() {
        //variable for return " true" if game will continue or "false" in case of drawn
        boolean fieldCheck = true;
        //variables for to assigning values of checked indexes and String variable fieldSum for concatenation char to String
        char field1;
        char field2;
        char field3;
        String fieldSum;
        //variables for checking presence of X & 0
        boolean case1;
        boolean case2;
        //starts to check draw option after 7-th move of players
        if (numberOfmoves >= 7) {
            boolean lines1[] = {true, true, true};
            boolean lines2[] = {true, true, true};
            boolean linesOneToSixResult[] = new boolean[lines1.length + lines2.length];

            System.arraycopy(lines1, 0, linesOneToSixResult, 0, lines1.length);
            System.arraycopy(lines2, 0, linesOneToSixResult, lines1.length, lines2.length);

//lines from 1 to 3
            for (int i = 0; i < lines1.length; i++) {
                lines1[i] = false;
                field1 = gameField[i][0];
                field2 = gameField[i][1];
                field3 = gameField[i][2];

                //concatenation
                fieldSum = String.valueOf(field1) + field2 + field3;

                //"contains" method for search X&0
                case1 = fieldSum.contains("X");
                case2 = fieldSum.contains("0");

                lines1[i] = (case1 && case2);
            }
            //lines from 4 to 6
            for (int i = 0; i < lines2.length; i++) {
                lines2[i] = false;
                field1 = gameField[0][i];
                field2 = gameField[1][i];
                field3 = gameField[2][i];

                //concatenation
                fieldSum = String.valueOf(field1) + field2 + field3;

                //"contains" method for search X&0
                case1 = fieldSum.contains("X");
                case2 = fieldSum.contains("0");

                lines2[i] = (case1 && case2);
            }
            // Х00
            // 0Х0
            // 00Х
            boolean line7check = false;
            field1 = gameField[0][0];
            field2 = gameField[1][1];
            field3 = gameField[2][2];
            fieldSum = String.valueOf(field1) + field2 + field3;
            case1 = fieldSum.contains("X");
            case2 = fieldSum.contains("0");
            if (case1 && case2) {
                line7check = true;
            }
            // 00X
            // 0X0
            // Х00
            boolean line8check = false;
            field1 = gameField[0][2];
            field2 = gameField[1][1];
            field3 = gameField[2][0];
            fieldSum = String.valueOf(field1) + field2 + field3;
            case1 = fieldSum.contains("X");
            case2 = fieldSum.contains("0");
            if (case1 && case2) {
                line8check = true;
            }
            if (linesOneToSixResult[0] && linesOneToSixResult[1] && linesOneToSixResult[2] && linesOneToSixResult[3] && linesOneToSixResult[4] && linesOneToSixResult[5] && line7check && line8check) {
                fieldCheck = false;
            }
        }
        return fieldCheck;
    }

    public static void main(String[] args) {
        System.out.println("Game start!");

        while (gameStatus() == ' ' && canMove()) {
            playerMove('X');
            numberOfmoves++;
            printVisual(gameField);
            if (gameStatus() == 'X') {
                System.out.println("Player Х win!");
                break;
            }
            if (gameStatus() == '0') {
                System.out.println("Player 0 win!");
                break;
            }
            playerMove('0');
            numberOfmoves++;
            printVisual(gameField);
            if (gameStatus() == ' ' && !canMove()) {
                System.out.println("Draw!");
                break;
            }
        }
    }
}