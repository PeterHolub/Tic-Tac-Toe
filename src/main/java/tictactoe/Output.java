package tictactoe;

class Output {
    private static final int NUM_OF_MOVES_TO_WIN = 7;
    private static final char FREE_FIELD = '*';

    boolean canMove(char[][] gameField) {

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
        if (Static.getNumberOfmoves() >= NUM_OF_MOVES_TO_WIN) {
            boolean lines1[] = {true, true, true};
            boolean lines2[] = {true, true, true};
            boolean linesOneToSixResult[] = new boolean[lines1.length + lines2.length];

            System.arraycopy(lines1, 0, linesOneToSixResult, 0, lines1.length);
            System.arraycopy(lines2, 0, linesOneToSixResult, lines1.length, lines2.length);
            //lines from 1 to 3
            for (int i = 0; i < lines1.length;
                 i++) {
                lines1[i] = false;
                field1 = gameField[i][0];
                field2 = gameField[i][1];
                field3 = gameField[i][2];


                //concatenation
                fieldSum = String.valueOf(field1) + field2 + field3;

                //"contains" method for search X&0
                case1 = fieldSum.contains(String.valueOf(Static.PLAYER_ONE_ALIAS));
                case2 = fieldSum.contains(String.valueOf(Static.PLAYER_TWO_ALIAS));

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
                case1 = fieldSum.contains(String.valueOf(Static.PLAYER_ONE_ALIAS));
                case2 = fieldSum.contains(String.valueOf(Static.PLAYER_TWO_ALIAS));

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
            case1 = fieldSum.contains(String.valueOf(Static.PLAYER_ONE_ALIAS));
            case2 = fieldSum.contains(String.valueOf(Static.PLAYER_TWO_ALIAS));
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
            case1 = fieldSum.contains(String.valueOf(Static.PLAYER_ONE_ALIAS));
            case2 = fieldSum.contains(String.valueOf(Static.PLAYER_TWO_ALIAS));
            if (case1 && case2) {
                line8check = true;
            }
            if (linesOneToSixResult[0] && linesOneToSixResult[1] && linesOneToSixResult[2] && linesOneToSixResult[3] && linesOneToSixResult[4] && linesOneToSixResult[5] && line7check && line8check) {
                fieldCheck = false;
            }
        }
        return fieldCheck;
    }

    char gameStatus(char[][] gameField) {
        char winner = ' ';
        //horizon lines check
        for (int i = 0; i < 3; i++) {
            if (gameField[i][0] == gameField[i][1] && gameField[i][1] == gameField[i][2]
                    && gameField[i][0] != FREE_FIELD ) {
                winner = gameField[i][0];// return value from array
                break;
            }
        }
        // vertical lines check
        if (winner == ' ') {
            for (int i = 0; i < 3; i++) {
                if (gameField[0][i] == gameField[1][i] && gameField[1][i] == gameField[2][i]
                        && gameField[0][i] != FREE_FIELD ) {
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
                    && gameField[0][0] != FREE_FIELD ) {
                winner = gameField[0][0];
            }
        }
        // 00X
        // 0X0
        // Х00
        if (winner == ' ') {
            if (gameField[0][2] == gameField[1][1] && gameField[1][1] == gameField[2][0]
                    && gameField[0][2] != FREE_FIELD ) {
                winner = gameField[0][2];
            }
        }
        // returns space if no winner
        return winner;
    }

}
