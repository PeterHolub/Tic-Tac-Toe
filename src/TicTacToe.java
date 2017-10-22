import java.util.Scanner;
public class TicTacToe {
    private static int numberOfmoves;
    private static char[][] gameField =
                   {{'*', '*', '*'},
                    {'*', '*', '*'},
                    {'*', '*', '*'}};

    private static int[] inputCoords() {
        Scanner sc1 = new Scanner(System.in);
        int coordX, coordY;
        String forSplit;
        String inputMessage = "Введите координаты (через пробел) для размещенния хода игрока ";
        forSplit = sc1.nextLine();
        //validation of input characters
        while (!forSplit.matches("\\d\\s\\d")) {
            System.out.println("Неправильный формат координат!");
            forSplit = sc1.nextLine();
        }
        coordX = Integer.parseInt(forSplit.split(" ")[0]) - 1;
        coordY = Integer.parseInt(forSplit.split(" ")[1]) - 1;
        // checking if indexes are not out of bounds
        while (coordX < 0 || coordX > 2 || coordY < 0 || coordY > 2) {
            System.out.println("Неверные значения! Указаные индексы больше или меньше возможных значений!");
            System.out.println(inputMessage);
            forSplit = sc1.nextLine();
            coordX = Integer.parseInt(forSplit.split(" ")[0]) - 1;
            coordY = Integer.parseInt(forSplit.split(" ")[1]) - 1;
        }

        //checking for free indexes in massive (game will not continue without player move)
        while (gameField[coordX][coordY] == '0' || gameField[coordX][coordY] == 'X') {
            System.out.println("Неверные значения! Здесь уже был сделан ход");
            System.out.println(inputMessage);
            forSplit = sc1.nextLine();
            coordX = Integer.parseInt(forSplit.split(" ")[0]) - 1;
            coordY = Integer.parseInt(forSplit.split(" ")[1]) - 1;
        }
        return new int[]{coordX, coordY};
    }
    private static void playerXmove() {
        System.out.println("Ходит Игрок Х ");
        int[] buffer = inputCoords();
        int coordX = buffer[0];
        int coordY = buffer[1];
        gameField[coordX][coordY] = 'X';
    }
    private static void player0move() {
        System.out.println("Ходит Игрок 0 ");
        int[] buffer = inputCoords();
        int coordX = buffer[0];
        int coordY = buffer[1];
        gameField[coordX][coordY] = '0';

    }
    private static void printField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(gameField[i][j]);
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
                winner = gameField[i][0];// return value from massive
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
            //ХХХ
            //000
            //000
            boolean line1check = false;
            field1 = gameField[0][0];
            field2 = gameField[0][1];
            field3 = gameField[0][2];
            //concatenation
            fieldSum = String.valueOf(field1) + field2 + field3;
            //"contains" method for search X&0
            case1 = fieldSum.contains("X");
            case2 = fieldSum.contains("0");
            if (case1 && case2) {
                line1check = true;
            }
            //000
            //XXX
            //000
            boolean line2check = false;
            field1 = gameField[1][0];
            field2 = gameField[1][1];
            field3 = gameField[1][2];
            fieldSum = String.valueOf(field1) + field2 + field3;
            case1 = fieldSum.contains("X");
            case2 = fieldSum.contains("0");
            if (case1 && case2) {
                line2check = true;
            }
            //000
            //000
            //XXX
            boolean line3check = false;
            field1 = gameField[2][0];
            field2 = gameField[2][1];
            field3 = gameField[2][2];
            fieldSum = String.valueOf(field1) + field2 + field3;
            case1 = fieldSum.contains("X");
            case2 = fieldSum.contains("0");
            if (case1 && case2) {
                line3check = true;
            }
            //X00
            //X00
            //X00
            boolean line4check = false;
            field1 = gameField[0][0];
            field2 = gameField[1][0];
            field3 = gameField[2][0];
            fieldSum = String.valueOf(field1) + field2 + field3;
            case1 = fieldSum.contains("X");
            case2 = fieldSum.contains("0");
            if (case1 && case2) {
                line4check = true;
            }
            //0X0
            //0X0
            //0X0
            boolean line5check = false;
            field1 = gameField[0][1];
            field2 = gameField[1][1];
            field3 = gameField[2][1];
            fieldSum = String.valueOf(field1) + field2 + field3;
            case1 = fieldSum.contains("X");
            case2 = fieldSum.contains("0");
            if (case1 && case2) {
                line5check = true;
            }
            //00X
            //00X
            //00X
            boolean line6check = false;
            field1 = gameField[0][2];
            field2 = gameField[1][2];
            field3 = gameField[2][2];
            fieldSum = String.valueOf(field1) + field2 + field3;
            case1 = fieldSum.contains("X");
            case2 = fieldSum.contains("0");
            if (case1 && case2) {
                line6check = true;
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

            if (line1check && line2check && line3check && line4check && line5check && line6check && line7check && line8check) {
                fieldCheck = false;
            }
        }
        return fieldCheck;
    }
    public static void main(String[] args) {
        System.out.println("Начало игры!");
        printField();
        while (gameStatus() == ' ' && canMove()) {

            playerXmove();
            numberOfmoves++;
            printField();
            if (gameStatus() == 'X') {
                System.out.println("Победа игрока Х!");
                break;
            }
            if (gameStatus() == '0') {
                System.out.println("Победа игрока 0!");
                break;
            }
            player0move();
            numberOfmoves++;
            printField();
            if (gameStatus() == ' ' && !canMove()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }
}