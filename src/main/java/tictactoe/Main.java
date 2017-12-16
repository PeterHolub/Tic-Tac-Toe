package tictactoe;

public class Main {
    private static int numberOfmoves;


    static int getNumberOfmoves() {
        return numberOfmoves;
    }

    static char[][] getFieldMap() {
        return fieldMap;
    }

     static char[][] gameField =

            {{'*', '*', '*'},
                    {'*', '*', '*'},
                    {'*', '*', '*'}};
    private static char[][] fieldMap =
            {{'1', '2', '3'},
                    {'4', '5', '6'},
                    {'7', '8', '9'}};


    static void printVisual(char[][] arrayTwoD) {
        if (arrayTwoD == fieldMap)
            System.out.println("Here is field map for players moves:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arrayTwoD[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Output output = new Output();
        Input input = new Input();

        System.out.println("Game start!");

        while (output.gameStatus() == ' ' && output.canMove()) {
            input.playerMove('X');
            Main.numberOfmoves++;
            printVisual(gameField);
            if (output.gameStatus() == 'X') {
                System.out.println("Player Х win!");
                break;
            }
            if (output.gameStatus() == '0') {
                System.out.println("Player 0 win!");
                break;
            }
            input.playerMove('0');
            numberOfmoves++;
            printVisual(gameField);
            if (output.gameStatus() == ' ' && !output.canMove()) {
                System.out.println("Draw!");
                break;
            }
        }
    }
}
