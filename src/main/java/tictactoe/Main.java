package tictactoe;


import java.io.IOException;

public class Main {

     void playersMovement(char playerAlias) throws IOException {

        Static.playerMove(playerAlias);
        Static.setNumberOfmoves();
        Static.printVisual(Static.getFieldMap());
        Static.printVisual(Static.getGameField());

    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Output output = new Output();
        Messages messages = new Messages();
        System.out.println(messages.getMessages().getProperty("start"));

        while (output.gameStatus(Static.getGameField()) == ' ' && output.canMove(Static.getGameField())) {

            main.playersMovement(Static.PLAYER_ONE_ALIAS);
            if (output.gameStatus(Static.getGameField()) == Static.PLAYER_ONE_ALIAS) {
                System.out.println(messages.getMessages().getProperty("xWin"));
                break;
            }
            main.playersMovement(Static.PLAYER_TWO_ALIAS);
            if (output.gameStatus(Static.getGameField()) == Static.PLAYER_TWO_ALIAS) {
                System.out.println(messages.getMessages().getProperty("0Win"));
                break;
            }
            if (output.gameStatus(Static.getGameField()) == ' ' && !output.canMove(Static.getGameField())) {
                System.out.println(messages.getMessages().getProperty("draw"));
                break;
            }
        }
    }
}
