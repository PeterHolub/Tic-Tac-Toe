package tictactoe;

public class Main {
    public static void main(String[] args) {
        Output output = new Output();
        System.out.println("Game start!");
        Static.printVisual(Static.getFieldMap());

        while (output.gameStatus(Static.getGameField()) == ' ' && output.canMove(Static.getGameField())) {
            Static.playerMove('X');
            Static.setNumberOfmoves();
            Static.printVisual(Static.getGameField());
            if (output.gameStatus(Static.getGameField()) == 'X') {
                System.out.println("Player Х win!");
                break;
            }
            if (output.gameStatus(Static.getGameField()) == '0') {
                System.out.println("Player 0 win!");
                break;
            }
            Static.playerMove('0');
            Static.setNumberOfmoves();
            Static.printVisual(Static.getGameField());
            if (output.gameStatus(Static.getGameField()) == ' ' && !output.canMove(Static.getGameField())) {
                System.out.println("Draw!");
                break;
            }
        }
    }
}
