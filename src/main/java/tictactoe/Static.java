package tictactoe;

class Static {
    private static int numberOfmoves;

    static void setNumberOfmoves() {
        Static.numberOfmoves++;
    }

    static int getNumberOfmoves() {
        return numberOfmoves;
    }

    private static char[][] gameField =
            {{'*', '*', '*'},

                    {'*', '*', '*'},
                    {'*', '*', '*'}};

    static char[][] getGameField() {
        return gameField;

    }

    private static char[][] fieldMap =
            {{'1', '2', '3'},
                    {'4', '5', '6'},
                    {'7', '8', '9'}};

    static char[][] getFieldMap() {
        return fieldMap;
    }

    static void printVisual(char[][] arrayTwoD) {
        if (arrayTwoD == fieldMap) {
            System.out.println("Here is field map for players moves:");
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arrayTwoD[i][j]);
            }
            System.out.println();
        }
    }

    static void playerMove(char playerAlias) {
        Input input = new Input();
        System.out.println("Player " + playerAlias + " move ");
        int[] buffer = input.inputCoords(input.alias(input.scanner()));
        int coordY = buffer[0];
        int coordX = buffer[1];
        gameField[coordY][coordX] = playerAlias;
    }
}
